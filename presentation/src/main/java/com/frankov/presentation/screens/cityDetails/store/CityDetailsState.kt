package com.frankov.presentation.screens.cityDetails.store

import com.frankov.data.models.weather.CurrentWeather

internal data class CityDetailsState(
    val weather: CurrentWeather = CurrentWeather(),
    val date: String = "",
    val errorMessage: String? = null
)