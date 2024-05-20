package com.alexesquerdo.giphy_app.network.source

import arrow.core.Either
import com.alexesquerdo.giphy_app.network.responses.categories.NetworkCategories
import com.alexesquerdo.giphy_app.network.responses.emoji.NetworkEmojis
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import com.alexesquerdo.giphy_app.network.utils.Failure

interface DataSource {
    suspend fun getTrending(): Either<Failure, NetworkTrending>
    suspend fun getEmojis(): Either<Failure, NetworkEmojis>
    suspend fun getCategories(): Either<Failure, NetworkCategories>
}