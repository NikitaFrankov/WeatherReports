package com.frankov.data.network.api

import com.frankov.data.network.models.pojo.Weater
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET
    suspend fun fetchCurrentWeather(
        @Query("lat") lat: Int,
        @Query("lon") lon: Int,
        @Query("appid") token: String,
    ): Response<Weater>
}