package com.alexesquerdo.giphy_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alexesquerdo.giphy_app.database.converters.GiphyConverter
import com.alexesquerdo.giphy_app.database.dao.TrendingDao
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity

@Database(
    entities = [GiphyItemEntity::class],
    version = 1
)
@TypeConverters(GiphyConverter::class)
abstract class TrendingDatabase : RoomDatabase() {
    abstract fun trendingDao(): TrendingDao
}