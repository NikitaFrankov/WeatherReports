package com.frankov.common

import com.beapps.mvi.model.Model
import com.frankov.common.utils.AppDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger

data class StoreData<Effect, State>(
    val middleware: Set<Middleware<Effect, State>>,
    val initState: State,
    val initEffects: List<Effect>,
    val reducer: Reducer<Effect, State>,
    val dispatchers: AppDispatchers,
    val retry: Int = 3,
    val errorHandler: suspend FlowCollector<Effect>.(Throwable) -> Unit = {}
)

@Suppress("EXPERIMENTAL_API_USAGE")
class Store<Effect, State>(
    private val coroutineScope: CoroutineScope,
    private val data: StoreData<Effect, State>
) {
    private val state = MutableStateFlow(data.initState)
    private val effects = MutableSharedFlow<Effect>()
    private val internalEffects = MutableSharedFlow<Effect>()
    private val mutex = Mutex()

    val stateFlow: StateFlow<State> = state.asStateFlow()
    val effectFlow: SharedFlow<Effect> = internalEffects.asSharedFlow()

    init {
        val initEffects = data.initEffects.asFlow()
        val middleFlow = data.middleware.map {
            apply(it, initEffects, AtomicInteger(0))
        }.merge()
            .onEach {
                coroutineScope.launch {
                    internalEffects.emit(it)
                }
            }

        listOf(initEffects, effects, middleFlow)
            .merge()
            .onEach(::apply)
            .launchIn(coroutineScope)
    }

    fun effect(effect: Effect) {
        coroutineScope.launch {
            effects.emit(effect)
        }
    }

    private suspend fun apply(effect: Effect) = mutex.withLock {
        state.emit(
            data.reducer(effect, state.value)
        )
    }

    private fun apply(
        middleware: Middleware<Effect, State>,
        initEffects: Flow<Effect>,
        retryCount: AtomicInteger
    ): Flow<Effect> =
        middleware(
            listOf(initEffects, effects.asSharedFlow(), internalEffects.asSharedFlow()).merge(),
            state.asStateFlow()
        ).catch { e ->
            data.errorHandler(this, e)
            if (data.retry < 0 || retryCount.incrementAndGet() <= data.retry) {
                // переподписываемся на middleware в котором произошла ошибка
                // т.к. получивший ошибку flow - находится в терминальном состоянии
                emitAll(apply(middleware, emptyFlow(), retryCount))
            }
        }
}

@Suppress("EXPERIMENTAL_API_USAGE")
fun <State, Effect> Model<State, Effect>.makeStore(
    data: StoreData<Effect, State>
) = Store(this, data)