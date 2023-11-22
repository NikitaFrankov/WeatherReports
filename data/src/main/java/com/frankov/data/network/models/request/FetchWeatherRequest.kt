package com.frankov.data.network.models.request

import com.frankov.data.network.models.location.Coordinates

data class FetchWeatherRequest(
    val token: String,
    val coordinates: Coordinates
)