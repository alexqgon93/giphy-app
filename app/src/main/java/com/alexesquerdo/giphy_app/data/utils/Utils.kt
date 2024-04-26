package com.alexesquerdo.giphy_app.data.utils

import arrow.core.Either
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.network.utils.Failure

fun Failure.toAppError(): AppError {
    return when (this) {
        is Failure.BadRequest -> AppError.BadRequest(message)
        is Failure.ServerError -> AppError.ServerError(message)
        is Failure.Unknown -> AppError.Unknown(message)
        Failure.NoConnectionError -> AppError.NoConnectionError
        Failure.Connectivity -> AppError.Connectivity
        is Failure.Server -> AppError.Server
    }
}

fun <T, R> Either<Failure, T>.mapResult(successTransform: (T) -> R): Either<AppError, R> {
    return fold({ error ->
        Either.Left(
            error.toAppError()
        )
    }, { success -> Either.Right(successTransform(success)) })
}