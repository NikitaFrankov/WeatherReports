package com.frankov.presentation.screens

import com.frankov.presentation.navigation.NavigationFactory
import com.frankov.presentation.screens.cityDetails.CityDetailsScreenModule
import org.koin.dsl.module

object ScreensModule {

    val module = module {
        single { NavigationFactory() }
    } + CityDetailsScreenModule.module
}