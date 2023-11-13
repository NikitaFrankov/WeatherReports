package com.frankov.presentation.navigation

internal sealed class Destinations(val route: String) {
    object Home: Destinations("home")
}