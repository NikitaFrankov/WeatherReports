package com.frankov.presentation.screens.home.models

import com.frankov.data.network.models.weather.CurrentWeather

internal data class HomeUiState(
    val weather: CurrentWeather? = null,
    val errorMessage: String? = null
)