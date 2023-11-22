package com.frankov.data.network.models.pojo

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("coord")
    var coord: Coord,
    @SerializedName("main")
    var main: Main,
    @SerializedName("rain")
    var rain: Rain,
    @SerializedName("clouds")
    var clouds: Clouds,
    @SerializedName("wind")
    var wind: Wind,
    @SerializedName("weather")
    var weather: ArrayList<WeatherItem> = arrayListOf(),
    @SerializedName("base")
    var base: String? = null,
    @SerializedName("visibility")
    var visibility: Int? = null,
    @SerializedName("dt")
    var dt: Int? = null,
    @SerializedName("sys")
    var sys: Sys? = Sys(),
    @SerializedName("timezone")
    var timezone: Int? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("cod")
    var cod: Int? = null
)