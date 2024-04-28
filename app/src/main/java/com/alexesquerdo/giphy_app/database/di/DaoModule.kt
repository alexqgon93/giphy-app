package com.alexesquerdo.giphy_app.database.di

import com.alexesquerdo.giphy_app.database.TrendingDatabase
import com.alexesquerdo.giphy_app.database.dao.TrendingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesTrendingDao(appDatabase: TrendingDatabase): TrendingDao = appDatabase.trendingDao()
}