package com.frankov.data.network.repositories.weather

import com.frankov.data.network.dataSources.WeatherRemoteDataSource
import com.frankov.data.network.models.pojo.Weather
import com.frankov.data.network.models.request.FetchWeatherRequest
import retrofit2.Response

internal class WeatherRepositoryImpl(
    private val weatherSource: WeatherRemoteDataSource
): WeatherRepository {
    override suspend fun fetchWeather(request: FetchWeatherRequest): Response<Weather> =
        weatherSource.obtainData(request)
}