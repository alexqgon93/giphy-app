package com.alexesquerdo.giphy_app.network.sources

import arrow.core.getOrElse
import com.alexesquerdo.giphy_app.network.common.BaseDataSourceTest
import com.alexesquerdo.giphy_app.network.common.MockApiResponse
import com.alexesquerdo.giphy_app.network.source.DataSource
import com.alexesquerdo.giphy_app.network.source.DataSourceImp
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

internal class DataSourceImpTest : BaseDataSourceTest<DataSource>() {

    @Test
    fun `test trending endpoint on Success`() = runBlocking {
        server.enqueue(MockApiResponse.serviceTrendingSuccess())
        val testService = dataSource.getTrending()
        val result: String = testService.map { data -> data.giphyItem.first().type }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isRight())
        Assertions.assertEquals("gif", result)
    }

    @Test
    fun `test trending endpoint on Error`() = runBlocking {
        server.enqueue(MockApiResponse.serviceTrendingError())
        val testService = dataSource.getTrending()
        val result: String = testService.map { data -> data.giphyItem.first().type }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isLeft())
        Assertions.assertEquals("Error", result)
    }

    @Test
    fun `test emojis endpoint on Success`() = runBlocking {
        server.enqueue(MockApiResponse.serviceEmojisSuccess())
        val testService = dataSource.getEmojis()
        val result: String = testService.map { data -> data.emojis.first().type }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isRight())
        Assertions.assertEquals("emoji", result)
    }

    @Test
    fun `test emojis endpoint on Error`() = runBlocking {
        server.enqueue(MockApiResponse.serviceEmojisError())
        val testService = dataSource.getEmojis()
        val result: String = testService.map { data -> data.emojis.first().type }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isLeft())
        Assertions.assertEquals("Error", result)
    }

    @Test
    fun `test categories endpoint on Success`() = runBlocking {
        server.enqueue(MockApiResponse.serviceCategoriesSuccess())
        val testService = dataSource.getCategories()
        val result: String = testService.map { data -> data.categories.first().name }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isRight())
        Assertions.assertEquals("Reactions", result)
    }

    @Test
    fun `test categories endpoint on Error`() = runBlocking {
        server.enqueue(MockApiResponse.serviceCategoriesError())
        val testService = dataSource.getCategories()
        val result: String = testService.map { data -> data.categories.first().name }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isLeft())
        Assertions.assertEquals("Error", result)
    }

    override fun provideDataSource(): DataSource = DataSourceImp(networkModule.apiService)
}