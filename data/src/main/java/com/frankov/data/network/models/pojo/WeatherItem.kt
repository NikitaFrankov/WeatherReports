package com.frankov.data.network.models.pojo

import com.google.gson.annotations.SerializedName

data class WeatherItem(
  @SerializedName("id")
  var id: Int? = null,
  @SerializedName("main")
  var main: String? = null,
  @SerializedName("description")
  var description: String? = null,
  @SerializedName("icon")
  var icon: String? = null
)