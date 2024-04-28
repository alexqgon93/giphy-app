package com.alexesquerdo.giphy_app.data.repository

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.mappers.toDomainModel
import com.alexesquerdo.giphy_app.data.utils.mapResult
import com.alexesquerdo.giphy_app.database.dao.TrendingDao
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.Trending
import com.alexesquerdo.giphy_app.network.source.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val dataSource: DataSource,
    private val trendingDao: TrendingDao,
) : Repository {
    override suspend fun getTrending(): Either<AppError, Trending> =
        dataSource.getTrending(0, 100).mapResult { it.toDomainModel() }

    /*override fun getAllQuotesFromDB(): Flow<List<GiphyItem>> =
        trendingDao.getTrendingData().map { it.toDomainModel() }*/
}