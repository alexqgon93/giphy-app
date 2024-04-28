package com.alexesquerdo.giphy_app.data.di

import com.alexesquerdo.giphy_app.data.repository.Repository
import com.alexesquerdo.giphy_app.data.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface RepositoryBindsModule {
    @Binds
    fun bindsRepository(dataSource: RepositoryImp): Repository
}