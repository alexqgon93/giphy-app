package com.alexesquerdo.giphy_app.network.source

import arrow.core.Either
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import com.alexesquerdo.giphy_app.network.utils.Failure

fun interface DataSource {
    suspend fun getTrending(offset: Int, limit: Int): Either<Failure, NetworkTrending>
}