package com.alexesquerdo.giphy_app.network.api

import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

fun interface ApiService {
    
    @GET("/v1/gifs/trending")
    suspend fun getTrending(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<NetworkTrending>
}