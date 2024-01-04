package com.frankov.common.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BaseViewModel<S: State, A: Action>(
    private val reducer: Reducer<S, A>,
    initialState: S
): ViewModel() {
    private val actionFlow = MutableSharedFlow<A>(extraBufferCapacity = 128)

    private val _uiState = MutableStateFlow(initialState)
    internal val uiState: StateFlow<S> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            actionFlow.collect { action ->
                _uiState.update { state ->
                    reducer.reduce(state, action)
                }
            }
        }
    }

    fun emmit(action: A) {
        actionFlow.tryEmit(action)
    }
}