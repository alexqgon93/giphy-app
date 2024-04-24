package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAnalytics(
    @Json(name = "onclick")
    val onclick: NetworkOnClick,
    @Json(name = "onload")
    val onload: NetworkOnLoad,
    @Json(name = "onsent")
    val onsent: NetworkOnSent
)