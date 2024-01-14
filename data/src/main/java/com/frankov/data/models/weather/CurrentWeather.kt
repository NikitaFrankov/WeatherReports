package com.frankov.data.models.weather

import com.frankov.data.models.pojo.CurrentWeatherData
import com.frankov.data.models.pojo.Weather
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import com.frankov.data.models.weather.WeatherDescription.*

data class CurrentWeather(
    val cityTitle: String = "",
    val weatherDescription: String = "",
    val weatherIconPath: String = "",
    val temperature: String = "",
    val rainFall: String = "",
    val wind: String = "",
    val humidity: String = "",
    val time: String ="",
    val descriptionItems: List<WeatherDescription> = listOf()
) {
    companion object Mapper {
        private const val DATE_PATTERN = "yyyy-MM-dd HH:mm"
        private const val PRESENTABLE_DATE_PATTERN = "d MMMM yyyy"
        private const val DAY_OF_WEEK_PATTERN = "EEEE"
        private const val HTTPS = "https:"

        fun from(data: Weather) = with(data) {
            CurrentWeather(
                cityTitle = "${location?.name}, ${location?.country} ",
                weatherDescription = current?.condition?.text ?: "",
                weatherIconPath = HTTPS + current?.condition?.icon,
                time = getDateFrom(string = current?.lastUpdated ?: ""),
                descriptionItems = createDescriptionItems(current ?: CurrentWeatherData())
            )
        }

        private fun getDateFrom(string: String): String {
            // Date
            val presentableFormatter = DateTimeFormatter.ofPattern(PRESENTABLE_DATE_PATTERN)
            val dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN)
            val localDate = LocalDate.parse(string, dateFormatter)

            // Day of week
            val locale = Locale.getDefault()
            val date = SimpleDateFormat(DATE_PATTERN, locale)
                .parse(string)
                ?: Date()
            val dayOfTheWeek = SimpleDateFormat(DAY_OF_WEEK_PATTERN, locale)
                .format(date)

            return dayOfTheWeek + ", " + localDate.format(presentableFormatter)
        }

        private fun createDescriptionItems(data: CurrentWeatherData) = with(data) {
            val temperature = (tempC?.toInt()?.toString() ?: "") + "°"
            val windSpeed = windMph?.toInt()?.toString() ?: ""
            val uvIndex = uv?.toString() ?: ""
            val humidity = humidity?.toString() ?: ""

            mutableListOf(
                Temperature(value = temperature),
                WindSpeed(value = windSpeed),
                UltravioletIndex(value = uvIndex),
                Humidity(value = humidity)
            )
        }
    }
}
