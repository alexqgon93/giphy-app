package com.alexesquerdo.giphy_app.network.responses.trending


import com.alexesquerdo.giphy_app.network.responses.common.NetworkUrl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAnalytics(
    @Json(name = "onclick")
    val onClick: NetworkUrl,
    @Json(name = "onload")
    val onLoad: NetworkUrl,
    @Json(name = "onsent")
    val onSent: NetworkUrl
)