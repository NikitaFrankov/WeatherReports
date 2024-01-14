package com.frankov.domain.stores.cityDetails.middlewares

import com.frankov.common.utils.AppDispatchers
import com.frankov.data.network.repositories.weather.WeatherRepository

class FetchWeatherMiddleware(
    private val repository: WeatherRepository,
    private val dispatchers: AppDispatchers
) {

}