package com.alexesquerdo.giphy_app.domain.usecases

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.repository.Repository
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.Trending
import javax.inject.Inject

class UseCaseTrending @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): Either<AppError, Trending> = repository.getTrending()
    /*.fold(
    ifLeft = {
        Either.Left(it)
        repository.insertTrending(it.toDatabase())
    },
    ifRight = {
        Either.Right(it) }
)
if (trending.isLeft()) {
    repository.insertTrending(trending.toDatabase())
} else {
    repository.getTrendingFormDd()
}
}*/
}
