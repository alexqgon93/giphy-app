package com.alexesquerdo.giphy_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkError(
    @Json(name = "data")
    val `data`: List<Any>,
    @Json(name = "meta")
    val meta: NetworkMeta
)