package com.frankov.data.models.pojo

import com.google.gson.annotations.SerializedName

data class Minutely(
    @SerializedName("dt")
    var dt: Int? = null,
    @SerializedName("precipitation")
    var precipitation: Int? = null
)