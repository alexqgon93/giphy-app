package com.alexesquerdo.giphy_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkDownsized(
    @Json(name = "height")
    val height: String,
    @Json(name = "size")
    val size: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: String
)