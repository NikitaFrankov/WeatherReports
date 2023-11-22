package com.frankov.data.network.repositories

import com.frankov.data.network.repositories.weather.WeatherRepository
import com.frankov.data.network.repositories.weather.WeatherRepositoryImpl
import org.koin.dsl.module

object RepositoriesModule {

    val module = module {
        factory<WeatherRepository> { WeatherRepositoryImpl(weatherSource = get()) }
    }
}