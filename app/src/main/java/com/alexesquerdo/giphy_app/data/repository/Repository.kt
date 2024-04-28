package com.alexesquerdo.giphy_app.data.repository

import arrow.core.Either
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.Trending
import kotlinx.coroutines.flow.Flow
 interface Repository {

    suspend fun getTrending(): Either<AppError, Trending>

    //fun getAllQuotesFromDB(): Flow<List<GiphyItem>>

}