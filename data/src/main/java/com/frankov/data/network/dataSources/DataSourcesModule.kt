package com.frankov.data.network.dataSources

import org.koin.dsl.module

internal object DataSourcesModule {

    val module = module {
        factory {
            WeatherRemoteDataSource(
                apiService = get(),
                dispatchers = get()
            )
        }
    }
}