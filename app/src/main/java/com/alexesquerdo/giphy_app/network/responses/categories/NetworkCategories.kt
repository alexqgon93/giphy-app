package com.alexesquerdo.giphy_app.network.responses.categories


import com.alexesquerdo.giphy_app.network.responses.common.NetworkMeta
import com.alexesquerdo.giphy_app.network.responses.common.NetworkPagination
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCategories(
    @Json(name = "data")
    val categories: List<NetworkCategory>,
    @Json(name = "meta")
    val meta: NetworkMeta,
    @Json(name = "pagination")
    val pagination: NetworkPagination
)