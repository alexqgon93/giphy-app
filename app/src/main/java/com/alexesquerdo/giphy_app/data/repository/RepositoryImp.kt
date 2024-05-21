package com.alexesquerdo.giphy_app.data.repository

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.mappers.toDomainModel
import com.alexesquerdo.giphy_app.data.utils.mapResult
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.categories.Categories
import com.alexesquerdo.giphy_app.domain.models.emoji.Emojis
import com.alexesquerdo.giphy_app.domain.models.treding.Trending
import com.alexesquerdo.giphy_app.network.source.DataSource
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val dataSource: DataSource,
) : Repository {
    override suspend fun getTrending(): Either<AppError, Trending> =
        dataSource.getTrending().mapResult { it.toDomainModel() }

    override suspend fun getEmojis(): Either<AppError, Emojis> =
        dataSource.getEmojis().mapResult { it.toDomainModel() }

    override suspend fun getCategories(): Either<AppError, Categories> =
        dataSource.getCategories().mapResult { it.toDomainModel() }
}