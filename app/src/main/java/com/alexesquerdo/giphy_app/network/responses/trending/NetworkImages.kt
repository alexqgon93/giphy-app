package com.alexesquerdo.giphy_app.network.responses.trending


import com.alexesquerdo.giphy_app.network.responses.common.NetworkMeasures
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImages(
    @Json(name = "fixed_height")
    val fixedHeight: NetworkMeasures,
    @Json(name = "fixed_height_downsampled")
    val fixedHeightDownSampled: NetworkMeasures,
    @Json(name = "fixed_height_small")
    val fixedHeightSmall: NetworkMeasures,
    @Json(name = "fixed_width")
    val fixedWidth: NetworkMeasures,
    @Json(name = "fixed_width_downsampled")
    val fixedWidthDownSampled: NetworkMeasures,
    @Json(name = "fixed_width_small")
    val fixedWidthSmall: NetworkMeasures,
    @Json(name = "original")
    val original: NetworkOriginal
)