package com.frankov.data.network.repositories.weather

import com.frankov.data.network.models.pojo.Weather
import com.frankov.data.network.models.request.FetchWeatherRequest
import retrofit2.Response

interface WeatherRepository {
    suspend fun fetchWeather(request: FetchWeatherRequest): Response<Weather>
}