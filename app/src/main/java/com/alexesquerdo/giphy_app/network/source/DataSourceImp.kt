package com.alexesquerdo.giphy_app.network.source

import arrow.core.Either
import com.alexesquerdo.giphy_app.network.api.ApiService
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import com.alexesquerdo.giphy_app.network.utils.Failure
import com.alexesquerdo.giphy_app.network.utils.tryCall
import javax.inject.Inject

class DataSourceImp @Inject constructor(
    private val apiService: ApiService,
) : DataSource {
    override suspend fun getTrending(offset: Int, limit: Int): Either<Failure, NetworkTrending> =
        tryCall {
            apiService.getTrending(offset = offset, limit = limit)
        }
}