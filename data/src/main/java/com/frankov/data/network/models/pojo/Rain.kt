package com.frankov.data.network.models.pojo

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    var inLastHour: Double? = null
)