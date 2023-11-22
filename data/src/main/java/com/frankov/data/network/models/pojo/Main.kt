package com.frankov.data.network.models.pojo

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp")
    var temp: Double,
    @SerializedName("feels_like")
    var feelsLike: Double? = null,
    @SerializedName("temp_min")
    var tempMin: Double? = null,
    @SerializedName("temp_max")
    var tempMax: Double? = null,
    @SerializedName("pressure")
    var pressure: Int? = null,
    @SerializedName("humidity")
    var humidity: Int? = null,
    @SerializedName("sea_level")
    var seaLevel: Int? = null,
    @SerializedName("grnd_level")
    var grndLevel: Int? = null
)