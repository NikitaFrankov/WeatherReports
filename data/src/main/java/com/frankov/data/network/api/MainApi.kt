package com.frankov.data.network.api

import com.frankov.data.network.models.pojo.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("weather")
    suspend fun fetchCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") token: String,
        @Query("lang") lang: String? = "ru",
        @Query("units") units: String? = "metric",
    ): Response<Weather>
}