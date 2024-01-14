package com.frankov.presentation.extensions

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.filter

@Suppress("UNCHECKED_CAST")
inline fun <reified R> SharedFlow<*>.filterIsInstance(): SharedFlow<R> = filter { it is R } as SharedFlow<R>