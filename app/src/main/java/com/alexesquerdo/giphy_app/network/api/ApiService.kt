package com.alexesquerdo.giphy_app.network.api

import com.alexesquerdo.giphy_app.network.responses.categories.NetworkCategories
import com.alexesquerdo.giphy_app.network.responses.emoji.NetworkEmojis
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/gifs/trending")
    suspend fun getTrending(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<NetworkTrending>

    @GET("/v2/emoji")
    suspend fun getEmoji(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<NetworkEmojis>

    @GET("v1/gifs/categories")
    suspend fun getCategories(): Response<NetworkCategories>
}

