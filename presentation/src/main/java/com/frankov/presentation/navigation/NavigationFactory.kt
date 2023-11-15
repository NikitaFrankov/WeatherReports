package com.frankov.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationFactory {
    private lateinit var appNavigation: NavHostController

    val instance get() = appNavigation

    @Composable
    fun Create() {
        appNavigation = rememberNavController()
    }
}