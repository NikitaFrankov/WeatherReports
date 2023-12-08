package com.frankov.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.frankov.presentation.screens.cityDetails.ui.HomeScreen
import org.koin.androidx.compose.getKoin

@Composable
fun NavigationAppHost() {
    val navController = getKoin().get<NavHostController>()

    NavHost(
        navController = navController,
        startDestination = Destinations.CityDetails.route
    ) {
        composable(Destinations.CityDetails.route) { HomeScreen() }
    }
}