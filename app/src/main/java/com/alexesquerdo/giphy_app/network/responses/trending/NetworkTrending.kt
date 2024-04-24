package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkTrending(
    @Json(name = "data")
    val `data`: List<NetworkData>,
    @Json(name = "meta")
    val meta: NetworkMeta,
    @Json(name = "pagination")
    val pagination: NetworkPagination
)