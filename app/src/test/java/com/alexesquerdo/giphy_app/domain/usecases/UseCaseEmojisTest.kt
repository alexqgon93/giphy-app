package com.alexesquerdo.giphy_app.domain.usecases

import arrow.core.Either
import com.alexesquerdo.giphy_app.data.repository.Repository
import com.alexesquerdo.giphy_app.domain.common.AppError
import com.alexesquerdo.giphy_app.mocks.emojisMock
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UseCaseEmojisTest {

    private lateinit var useCaseEmojis: UseCaseEmojis
    private val repository: Repository = mockk()

    @BeforeEach
    fun setUp() {
        useCaseEmojis = UseCaseEmojis(repository)
    }

    @Test
    fun `invoke returns emojis on success`() = runBlocking {
        coEvery { repository.getEmojis() } returns Either.Right(emojisMock)
        Assertions.assertEquals(Either.Right(emojisMock), useCaseEmojis.invoke())
    }

    @Test
    fun `invoke returns error on failure`() = runBlocking {
        val error = AppError.NoConnectionError
        coEvery { repository.getEmojis() } returns Either.Left(error)
        Assertions.assertEquals(Either.Left(error), useCaseEmojis.invoke())
    }
}