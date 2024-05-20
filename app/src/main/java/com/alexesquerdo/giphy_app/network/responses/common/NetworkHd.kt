package com.alexesquerdo.giphy_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkHd(
    @Json(name = "height")
    val height: String?,
    @Json(name = "mp4")
    val mp4: String,
    @Json(name = "mp4_size")
    val mp4Size: String,
    @Json(name = "width")
    val width: String?
)