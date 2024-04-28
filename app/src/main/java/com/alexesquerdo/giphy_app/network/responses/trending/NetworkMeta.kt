package com.alexesquerdo.giphy_app.network.responses.trending


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkMeta(
    @Json(name = "msg")
    val msg: String,
    @Json(name = "response_id")
    val responseId: String,
    @Json(name = "status")
    val status: Int
)