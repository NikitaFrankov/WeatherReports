package com.frankov.presentation.screens.cityDetails.store

import com.frankov.common.Reducer

internal class CityDetailsReducer: Reducer<CityDetailsEffect, CityDetailsState> {
    override fun invoke(effect: CityDetailsEffect, state: CityDetailsState) = when(effect) {
        else -> state
    }
}