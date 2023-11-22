package com.frankov.domain.useCases.home

import com.frankov.common.utils.AppDispatchers
import com.frankov.data.network.models.location.Coordinates
import com.frankov.data.network.models.request.FetchWeatherRequest
import com.frankov.data.network.models.weather.CurrentWeather
import com.frankov.data.network.repositories.weather.WeatherRepository
import kotlinx.coroutines.withContext

class FetchWeatherUseCase(
    private val repository: WeatherRepository,
    private val dispatchers: AppDispatchers
) {

    suspend operator fun invoke(coordinates: Coordinates) = withContext(dispatchers.io) {
        val request = FetchWeatherRequest(
            token = "e949f9a4be7cc9cbdfbc7b8d0eab1c36",
            coordinates = coordinates
        )
        val response = repository.fetchWeather(request).body()
        CurrentWeather.from(response!!)
    }
}