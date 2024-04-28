package com.alexesquerdo.giphy_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alexesquerdo.giphy_app.database.converters.TrendingConverters
import com.alexesquerdo.giphy_app.database.dao.TrendingDao
import com.alexesquerdo.giphy_app.database.models.AnalyticsEntity
import com.alexesquerdo.giphy_app.database.models.DataEntity
import com.alexesquerdo.giphy_app.database.models.ImagesEntity
import com.alexesquerdo.giphy_app.database.models.MeasuresEntity
import com.alexesquerdo.giphy_app.database.models.MetaEntity
import com.alexesquerdo.giphy_app.database.models.OriginalEntity
import com.alexesquerdo.giphy_app.database.models.PaginationEntity
import com.alexesquerdo.giphy_app.database.models.TrendingEntity
import com.alexesquerdo.giphy_app.database.models.UrlEntity
import com.alexesquerdo.giphy_app.database.models.UserEntity

@Database(
    entities = [
        AnalyticsEntity::class,
        DataEntity::class,
        ImagesEntity::class,
        MeasuresEntity::class,
        MetaEntity::class,
        OriginalEntity::class,
        PaginationEntity::class,
        TrendingEntity::class,
        UrlEntity::class,
        UserEntity::class,
    ],
    version = 1
)
@TypeConverters(TrendingConverters::class)
abstract class TrendingDatabase : RoomDatabase() {
    abstract fun trendingDao(): TrendingDao
}