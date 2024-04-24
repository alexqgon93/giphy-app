package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAnalytics(
    @Json(name = "onclick")
    val onClick: NetworkOnClick,
    @Json(name = "onload")
    val onLoad: NetworkOnLoad,
    @Json(name = "onsent")
    val onSent: NetworkOnSent
)