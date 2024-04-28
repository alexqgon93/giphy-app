package com.alexesquerdo.giphy_app.data.sources

import arrow.core.getOrElse
import com.alexesquerdo.giphy_app.data.common.BaseDataSourceTest
import com.alexesquerdo.giphy_app.data.common.MockApiResponse
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
        val result: String = testService.map { data -> data.data.first().type }
            .getOrElse { "Error" }
        Assertions.assertTrue(testService.isRight())
        Assertions.assertEquals("gif", result)
    }

    override fun provideDataSource(): DataSource = DataSourceImp(networkModule.apiService)
}