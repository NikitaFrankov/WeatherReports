package com.frankov.domain.useCases.home

import com.frankov.common.utils.AppDispatchers
import com.frankov.data.models.request.FetchWeatherRequest
import com.frankov.data.network.repositories.weather.WeatherRepository
import kotlinx.coroutines.withContext

class FetchWeatherUseCase(
    private val repository: WeatherRepository,
    private val dispatchers: AppDispatchers
) {

    suspend operator fun invoke(query: String) = withContext(dispatchers.io) {
        val request = FetchWeatherRequest(
            key = "40e3bbc7db87428580c183429232611",
            query = query
        )
        repository.fetchWeather(request).body()
    }
}