package com.beapps.mvi.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface Model<State, Effect> : CoroutineScope {
    val stateFlow: StateFlow<State>
    val effectFlow: SharedFlow<Effect>

    fun effect(effect: Effect)
}