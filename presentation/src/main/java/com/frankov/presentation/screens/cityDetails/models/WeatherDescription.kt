package com.frankov.presentation.screens.cityDetails.models

sealed class WeatherDescription(open val value: String) {
    data class UltravioletIndex(override val value: String): WeatherDescription(value)
    data class Temperature(override val value: String): WeatherDescription(value)
    data class WindSpeed(override val value: String): WeatherDescription(value)
    data class Humidity(override val value: String): WeatherDescription(value)
}