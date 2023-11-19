package com.frankov.common

import com.frankov.common.utils.AppDispatchers
import com.frankov.common.utils.DefaultDispatchers
import org.koin.dsl.module

object CommonModule {
    val module = module {
        single<AppDispatchers> { DefaultDispatchers() }
    }
}