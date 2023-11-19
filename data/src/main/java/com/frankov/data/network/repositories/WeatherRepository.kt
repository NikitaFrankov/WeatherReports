package com.frankov.data.network.repositories

import com.frankov.common.utils.AppDispatchers
import com.frankov.data.network.api.MainApi
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val dispatchers: AppDispatchers,
    private val apiService: MainApi
) {

    suspend fun obtainData(
        lon: Int,
        lat: Int,
        token: String
    ) = withContext(dispatchers.io) {
        apiService.fetchCurrentWeather(
            lat = lat,
            lon = lon,
            token = token
        )
    }
}