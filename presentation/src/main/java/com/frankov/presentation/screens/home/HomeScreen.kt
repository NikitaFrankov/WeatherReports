package com.frankov.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.androidx.compose.getKoin
import org.koin.androidx.compose.getViewModel

@Composable
internal fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    val router = getKoin().get<NavHostController>()

    HomeView()
}