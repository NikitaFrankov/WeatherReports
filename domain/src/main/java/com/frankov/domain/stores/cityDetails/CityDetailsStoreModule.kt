package com.frankov.domain.stores.cityDetails

import com.frankov.domain.stores.cityDetails.middlewares.FetchWeatherMiddleware
import org.koin.dsl.module

object CityDetailsStoreModule {
    val module = module {
        factory { FetchWeatherMiddleware(repository = get(), dispatchers = get()) }
    }
}