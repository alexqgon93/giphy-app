package com.alexesquerdo.giphy_app.network.common

import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

internal abstract class BaseDataSourceTest<T : Any> {
    val networkModule: TestNetworkModule = TestNetworkModule()
    lateinit var server: MockWebServer
    lateinit var dataSource: T

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        server = networkModule.mockWebServer
        server.start()
        dataSource = provideDataSource()
    }

    @AfterEach
    @Throws(Exception::class)
    fun after() {
        server.shutdown()
    }

    abstract fun provideDataSource(): T
}