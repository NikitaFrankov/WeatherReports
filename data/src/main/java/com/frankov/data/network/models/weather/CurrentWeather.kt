package com.frankov.data.network.models.weather

import com.frankov.data.network.models.pojo.Weather

data class CurrentWeather(
    val temperature: Int,
    val rainFall: String,
    val wind: String,
    val humidity: String
) {
    companion object Mapper {
        fun from(data: Weather) = CurrentWeather(
            temperature = data.main.temp.toInt(),
            rainFall = data.rain.inLastHour?.toInt()?.toString() ?: "",
            wind = data.wind.speed?.toInt()?.toString() ?: "",
            humidity = data.main.humidity?.toString() ?: ""
        )
    }
}
