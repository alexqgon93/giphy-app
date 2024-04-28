package com.alexesquerdo.giphy_app.data.repository

import arrow.core.Either
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.Trending

fun interface Repository {

    suspend fun getTrending(): Either<AppError, Trending>

}