package com.alexesquerdo.giphy_app.data.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.alexesquerdo.giphy_app.data.local.TrendingRemoteMediator
import com.alexesquerdo.giphy_app.database.TrendingDatabase
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity
import com.alexesquerdo.giphy_app.network.source.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object MediatorModule {

    @Provides
    @Singleton
    fun providePager(
        trendingDatabase: TrendingDatabase,
        dataSource: DataSource,
    ): Pager<Int, GiphyItemEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = TrendingRemoteMediator(
                dataSource = dataSource, trendingDatabase = trendingDatabase
            ),
            pagingSourceFactory = {
                trendingDatabase.trendingDao().pagingSource()
            }
        )
    }
}