package com.frankov.common.mvi

interface Reducer<S: State, A: Action> {
    fun reduce(state: S, action: A): S
}