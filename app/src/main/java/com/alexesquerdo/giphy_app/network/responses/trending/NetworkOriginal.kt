package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkOriginal(
    @Json(name = "frames")
    val frames: String,
    @Json(name = "hash")
    val hash: String,
    @Json(name = "height")
    val height: String,
    @Json(name = "mp4")
    val mp4: String,
    @Json(name = "mp4_size")
    val mp4Size: String,
    @Json(name = "size")
    val size: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "webp")
    val webp: String?,
    @Json(name = "webp_size")
    val webpSize: String?,
    @Json(name = "width")
    val width: String?
)