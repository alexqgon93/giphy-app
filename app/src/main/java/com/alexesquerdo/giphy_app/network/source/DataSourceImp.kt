package com.alexesquerdo.giphy_app.network.source

import arrow.core.Either
import com.alexesquerdo.giphy_app.network.api.ApiService
import com.alexesquerdo.giphy_app.network.responses.categories.NetworkCategories
import com.alexesquerdo.giphy_app.network.responses.emoji.NetworkEmojis
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import com.alexesquerdo.giphy_app.network.utils.Failure
import com.alexesquerdo.giphy_app.network.utils.tryCall
import javax.inject.Inject

class DataSourceImp @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getTrending(): Either<Failure, NetworkTrending> = tryCall {
        apiService.getTrending(offset = 0, limit = 4999)
    }

    override suspend fun getEmojis(): Either<Failure, NetworkEmojis> = tryCall {
        apiService.getEmoji(offset = 0, limit = 4999)
    }

    override suspend fun getCategories(): Either<Failure, NetworkCategories> = tryCall {
        apiService.getCategories()
    }
}