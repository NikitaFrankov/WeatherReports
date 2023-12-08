package com.frankov.data.models.request

data class FetchWeatherRequest(
    val key: String,
    val query: String
)