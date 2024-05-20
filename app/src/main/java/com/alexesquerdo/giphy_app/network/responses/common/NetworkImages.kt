package com.alexesquerdo.giphy_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImages(
    @Json(name = "downsized")
    val downsized: NetworkDownsized,
    @Json(name = "downsized_large")
    val downsizedLarge: NetworkDownsized,
    @Json(name = "downsized_medium")
    val downsizedMedium: NetworkDownsized,
    @Json(name = "downsized_small")
    val downsizedSmall: NetworkHd,
    @Json(name = "downsized_still")
    val downsizedStill: NetworkDownsized,
    @Json(name = "fixed_height")
    val fixedHeight: NetworkFixedWidth,
    @Json(name = "fixed_height_downsampled")
    val fixedHeightDownSampled: NetworkMeasures,
    @Json(name = "fixed_height_small")
    val fixedHeightSmall: NetworkFixedWidth,
    @Json(name = "fixed_height_small_still")
    val fixedHeightSmallStill: NetworkDownsized,
    @Json(name = "fixed_height_still")
    val fixedHeightStill: NetworkDownsized,
    @Json(name = "fixed_width")
    val fixedWidth: NetworkFixedWidth,
    @Json(name = "fixed_width_downsampled")
    val fixedWidthDownSampled: NetworkMeasures,
    @Json(name = "fixed_width_small")
    val fixedWidthSmall: NetworkFixedWidth,
    @Json(name = "fixed_width_small_still")
    val fixedWidthSmallStill: NetworkDownsized,
    @Json(name = "fixed_width_still")
    val fixedWidthStill: NetworkDownsized,
    @Json(name = "hd")
    val hd: NetworkHd,
    @Json(name = "looping")
    val looping: NetworkHd,
    @Json(name = "original")
    val original: NetworkOriginal,
    @Json(name = "original_mp4")
    val originalMp4: NetworkHd,
    @Json(name = "original_still")
    val originalStill: NetworkDownsized,
    @Json(name = "preview")
    val preview: NetworkHd,
    @Json(name = "preview_gif")
    val previewGif: NetworkDownsized,
    @Json(name = "preview_webp")
    val previewWebp: NetworkDownsized,
    @Json(name = "480w_still")
    val wStill: NetworkDownsized
)