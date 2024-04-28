package com.alexesquerdo.giphy_app.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrendingDao {
    @Query("SELECT * FROM gifentity")
    fun getTrendingData(): Flow<List<GiphyItemEntity>>

    @Upsert
    suspend fun upsertAll(giphyItems: List<GiphyItemEntity>)

    @Query("SELECT * FROM gifentity")
    fun pagingSource(): PagingSource<Int, GiphyItemEntity>

    @Query("DELETE FROM gifentity")
    suspend fun clearAll()
}