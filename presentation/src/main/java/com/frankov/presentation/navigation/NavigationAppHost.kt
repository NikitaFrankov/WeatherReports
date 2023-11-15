package com.frankov.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.frankov.presentation.screens.home.HomeScreen
import org.koin.androidx.compose.getKoin

@Composable
fun NavigationAppHost() {
    val navController = getKoin().get<NavHostController>()

    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        composable(Destinations.Home.route) { HomeScreen() }
    }
}