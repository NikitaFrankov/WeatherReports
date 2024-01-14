package com.frankov.presentation.screens.cityDetails.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.frankov.presentation.screens.cityDetails.CityDetailsViewModel
import com.frankov.presentation.screens.cityDetails.store.CityDetailsEffect.Navigate.*
import org.koin.androidx.compose.getKoin
import org.koin.androidx.compose.getViewModel

@Composable
internal fun HomeScreen() {
    val viewModel = getViewModel<CityDetailsViewModel>()
    val router = getKoin().get<NavHostController>()

    LaunchedEffect(key1 = Unit) {
        viewModel.navigationFlow.collect { effect ->
            when(effect) {
                is Back -> router.popBackStack()
            }
        }
    }

    HomeView(viewModel = viewModel)
}