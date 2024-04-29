package com.alexesquerdo.giphy_app.domain.usecases

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.repository.Repository
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.mocks.trendingMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UseCaseTrendingTest {

    private lateinit var useCaseTrending: UseCaseTrending
    private val repository: Repository = mockk()

    @BeforeEach
    fun setUp() {
        useCaseTrending = UseCaseTrending(repository)
    }

    @Test
    fun `invoke returns trending on success`() = runBlocking {
        coEvery { repository.getTrending() } returns Either.Right(trendingMock)
        Assertions.assertEquals(Either.Right(trendingMock), useCaseTrending.invoke())
    }

    @Test
    fun `invoke returns error on failure`() = runBlocking {
        val error = AppError.NoConnectionError
        coEvery { repository.getTrending() } returns Either.Left(error)
        Assertions.assertEquals(Either.Left(error), useCaseTrending.invoke())
    }
}