package com.frankov.presentation.screens.cityDetails.models

internal data class CityDetailsUiState(
    val weather: CurrentWeather = CurrentWeather(),
    val date: String = "",
    val errorMessage: String? = null
)