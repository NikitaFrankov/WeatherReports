package com.frankov.presentation.screens.cityDetails

import com.frankov.presentation.base.BaseViewModel
import com.frankov.presentation.extensions.filterIsInstance
import com.frankov.presentation.screens.cityDetails.store.CityDetailsEffect
import com.frankov.presentation.screens.cityDetails.store.CityDetailsEffect.*
import com.frankov.presentation.screens.cityDetails.store.CityDetailsInteractor
import com.frankov.presentation.screens.cityDetails.store.CityDetailsState

internal class CityDetailsViewModel(
    interactor: CityDetailsInteractor
): BaseViewModel<CityDetailsState, CityDetailsEffect, CityDetailsInteractor>(interactor) {

    override val errorFlow = interactor
        .effectFlow
        .filterIsInstance<ShowError>()
    override val navigationFlow = interactor
        .effectFlow
        .filterIsInstance<Navigate>()
}