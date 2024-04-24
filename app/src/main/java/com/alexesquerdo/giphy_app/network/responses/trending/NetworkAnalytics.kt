package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAnalytics(
    @Json(name = "onclick")
    val onclick: NetworkOnclick,
    @Json(name = "onload")
    val onload: NetworkOnload,
    @Json(name = "onsent")
    val onsent: NetworkOnsent
)