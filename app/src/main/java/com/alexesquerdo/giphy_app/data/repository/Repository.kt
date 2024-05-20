package com.alexesquerdo.giphy_app.data.repository

import arrow.core.Either
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.categories.Categories
import com.alexesquerdo.giphy_app.domain.models.emoji.Emojis
import com.alexesquerdo.giphy_app.domain.models.treding.Trending

interface Repository {
    suspend fun getTrending(): Either<AppError, Trending>
    suspend fun getEmojis(): Either<AppError, Emojis>
    suspend fun getCategories(): Either<AppError, Categories>

}