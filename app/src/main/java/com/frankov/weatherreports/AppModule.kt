package com.frankov.weatherreports

import com.frankov.presentation.navigation.NavigationFactory
import com.frankov.presentation.screens.ScreensModule
import com.frankov.weatherreports.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal object AppModule {

    fun module(app: App) = module {
        single { app }
        single { get<NavigationFactory>().instance }
        viewModel { MainViewModel() }
    } + ScreensModule.module
}