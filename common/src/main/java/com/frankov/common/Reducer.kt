package com.frankov.common

typealias Reducer<Effect, State> = (effect: Effect, state: State) -> State