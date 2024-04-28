package com.alexesquerdo.giphy_app.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity

@Dao
interface TrendingDao {

    @Upsert
    suspend fun upsertAll(giphyItems: List<GiphyItemEntity>)

    @Query("SELECT * FROM gifentity")
    fun pagingSource(): PagingSource<Int, GiphyItemEntity>

    @Query("DELETE FROM gifentity")
    suspend fun clearAll()
}