package com.frankov.data.network.dataSources

import com.frankov.common.utils.AppDispatchers
import com.frankov.data.network.api.MainApi
import com.frankov.data.network.models.request.FetchWeatherRequest
import kotlinx.coroutines.withContext

class WeatherRemoteDataSource(
    private val dispatchers: AppDispatchers,
    private val apiService: MainApi
) {
    suspend fun obtainData(request: FetchWeatherRequest) = withContext(dispatchers.io) {
        apiService.fetchCurrentWeather(
            lat = request.coordinates.lat,
            lon = request.coordinates.lon,
            token = request.token
        )
    }
}