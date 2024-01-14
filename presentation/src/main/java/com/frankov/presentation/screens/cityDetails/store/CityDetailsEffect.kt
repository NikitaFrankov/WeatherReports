package com.frankov.presentation.screens.cityDetails.store

internal sealed class CityDetailsEffect {
    data object Init: CityDetailsEffect()
    data object FetchWeather: CityDetailsEffect()

    data class ShowError(val message: String?): CityDetailsEffect()

    sealed class Navigate: CityDetailsEffect() {
        data object Back: Navigate()
    }
}