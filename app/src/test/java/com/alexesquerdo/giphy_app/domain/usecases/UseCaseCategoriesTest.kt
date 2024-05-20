package com.alexesquerdo.giphy_app.domain.usecases

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.repository.Repository
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.mocks.categoriesMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class UseCaseCategoriesTest {

    private lateinit var useCaseCategories: UseCaseCategories
    private val repository: Repository = mockk()

    @BeforeEach
    fun setUp() {
        useCaseCategories = UseCaseCategories(repository)
    }

    @Test
    fun `invoke returns categories on success`() = runBlocking {
        coEvery { repository.getCategories() } returns Either.Right(categoriesMock)
        Assertions.assertEquals(Either.Right(categoriesMock), useCaseCategories.invoke())
    }

    @Test
    fun `invoke returns error on failure`() = runBlocking {
        val error = AppError.NoConnectionError
        coEvery { repository.getCategories() } returns Either.Left(error)
        Assertions.assertEquals(Either.Left(error), useCaseCategories.invoke())
    }

}