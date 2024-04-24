package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImages(
    @Json(name = "fixed_height")
    val fixedHeight: NetworkFixedHeight,
    @Json(name = "fixed_height_downsampled")
    val fixedHeightDownsampled: NetworkFixedHeightDownsampled,
    @Json(name = "fixed_height_small")
    val fixedHeightSmall: NetworkFixedHeightSmall,
    @Json(name = "fixed_width")
    val fixedWidth: NetworkFixedWidth,
    @Json(name = "fixed_width_downsampled")
    val fixedWidthDownsampled: NetworkFixedWidthDownsampled,
    @Json(name = "fixed_width_small")
    val fixedWidthSmall: NetworkFixedWidthSmall,
    @Json(name = "original")
    val original: NetworkOriginal
)