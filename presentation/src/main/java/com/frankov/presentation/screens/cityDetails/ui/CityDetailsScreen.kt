package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel

@Composable
internal fun HomeScreen() {
    val viewModel = getViewModel<CityDetailsViewModel>()

    HomeView(viewModel = viewModel)
}