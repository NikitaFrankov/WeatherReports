package com.frankov.presentation.screens.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeScreenModule {
    val module = module {
        viewModel { HomeViewModel() }
    }
}