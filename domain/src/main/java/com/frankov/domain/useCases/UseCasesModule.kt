package com.frankov.domain.useCases

import com.frankov.domain.useCases.home.FetchWeatherUseCase
import org.koin.dsl.module

internal object UseCasesModule {

    val module = module {
        factory { FetchWeatherUseCase(repository = get(), dispatchers = get()) }
    }
}