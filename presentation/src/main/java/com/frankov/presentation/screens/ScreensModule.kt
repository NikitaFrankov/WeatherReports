package com.frankov.presentation.screens

import com.frankov.presentation.navigation.NavigationFactory
import org.koin.dsl.module

object ScreensModule {

    val module = module {
        single { NavigationFactory() }
    }
}