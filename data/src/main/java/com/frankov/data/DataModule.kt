package com.frankov.data

import com.frankov.data.network.repositories.WeatherRepository
import com.frankov.data.network.retrofit.RetrofitModule
import com.frankov.data.network.retrofit.RetrofitServicesModule
import org.koin.dsl.module

object DataModule {
    val module = module {
        factory {
            WeatherRepository(
                dispatchers = get(),
                apiService = get()
            )
        }
    } + RetrofitModule.module +
        RetrofitServicesModule.module
}