package com.alexesquerdo.giphy_app.database.di

import android.content.Context
import androidx.room.Room
import com.alexesquerdo.giphy_app.database.TrendingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "trending_database"

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): TrendingDatabase =
        Room.databaseBuilder(
            context = context,
            klass = TrendingDatabase::class.java,
            name = DATABASE_NAME
        ).build()
}