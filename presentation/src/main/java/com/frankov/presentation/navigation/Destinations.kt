package com.frankov.presentation.navigation

internal sealed class Destinations(val route: String) {

    /** Main */
    data object CityDetails: Destinations("cityDetails")

    /** CityDetails */

}