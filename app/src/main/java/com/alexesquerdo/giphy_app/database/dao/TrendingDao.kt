package com.alexesquerdo.giphy_app.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alexesquerdo.giphy_app.database.models.DataEntity
import com.alexesquerdo.giphy_app.database.models.TrendingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrendingDao {
    @Query("SELECT * FROM `trending_entity`")
    fun getTrendingData(): Flow<List<TrendingEntity>>

    @Upsert
    suspend fun insertTrendingData(trending: TrendingEntity)
}