package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkOnload(
    @Json(name = "url")
    val url: String
)