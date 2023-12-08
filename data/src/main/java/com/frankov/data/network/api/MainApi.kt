package com.frankov.data.network.api

import com.frankov.data.models.pojo.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("current.json")
    suspend fun fetchCurrentWeather(
        @Query("key") key: String,
        @Query("q") query: String,
    ): Response<Weather>
}