package com.frankov.presentation.base

import androidx.lifecycle.ViewModel
import com.beapps.mvi.model.Model
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharedFlow

internal abstract class BaseViewModel<
    State: Any,
    Effect: Any,
    Interactor: Model<State, Effect>
>(
    private val interactor: Interactor
): ViewModel() {

    abstract val errorFlow: SharedFlow<Effect>
    abstract val navigationFlow: SharedFlow<Effect>

    val state = interactor.stateFlow

    fun effect(effect: Effect) {
        interactor.effect(effect)
    }

    override fun onCleared() {
        interactor.cancel()
        super.onCleared()
    }
}