package com.frankov.common

import kotlinx.coroutines.flow.Flow

typealias Middleware<Effect, State> = (effects: Flow<Effect>, states: Flow<State>) -> Flow<Effect>