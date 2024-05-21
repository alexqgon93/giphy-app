package com.alexesquerdo.giphy_app.network.responses.categories


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkSubcategory(
    @Json(name = "name")
    val name: String,
    @Json(name = "name_encoded")
    val nameEncoded: String
)