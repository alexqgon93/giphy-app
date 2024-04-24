package com.alexesquerdo.giphy_app.network.source

import arrow.core.Either
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import com.alexesquerdo.giphy_app.network.utils.Failure

fun interface DataSource {
    suspend fun getTrending(): Either<Failure, NetworkTrending>
}