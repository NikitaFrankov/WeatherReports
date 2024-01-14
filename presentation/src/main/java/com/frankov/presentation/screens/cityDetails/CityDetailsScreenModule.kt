package com.frankov.presentation.screens.cityDetails

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CityDetailsScreenModule {
    val module = module {
        viewModel {
            CityDetailsViewModel(interactor = get())
        }
    }
}