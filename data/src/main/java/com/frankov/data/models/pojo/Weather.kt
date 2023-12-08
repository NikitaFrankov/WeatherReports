package com.frankov.data.models.pojo

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("location")
    var location: Location? = Location(),
    @SerializedName("current")
    var current: CurrentWeatherData? = CurrentWeatherData()
)