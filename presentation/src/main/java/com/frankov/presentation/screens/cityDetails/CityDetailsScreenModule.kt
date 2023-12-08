package com.frankov.presentation.screens.cityDetails

import com.frankov.presentation.screens.cityDetails.ui.CityDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CityDetailsScreenModule {
    val module = module {
        viewModel { CityDetailsViewModel(fetchWeatherUseCase = get()) }
    }
}