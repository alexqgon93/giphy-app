package com.alexesquerdo.giphy_app.domain.usecases

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.repository.Repository
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.domain.models.categories.Categories
import javax.inject.Inject

class UseCaseCategories @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): Either<AppError, Categories> = repository.getCategories()
}