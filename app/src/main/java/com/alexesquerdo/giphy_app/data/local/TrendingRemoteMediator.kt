package com.alexesquerdo.giphy_app.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.alexesquerdo.giphy_app.data.mappers.toGifEntity
import com.alexesquerdo.giphy_app.database.TrendingDatabase
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity
import com.alexesquerdo.giphy_app.network.source.DataSource
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class TrendingRemoteMediator(
    private val dataSource: DataSource,
    private val trendingDatabase: TrendingDatabase,
) : RemoteMediator<Int, GiphyItemEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GiphyItemEntity>,
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.idGif / state.config.pageSize) + 1
                    }
                }
            }

            val trending = dataSource.getTrending(
                offset = loadKey,
                limit = state.config.pageSize,
            )
            trendingDatabase.withTransaction {
                /*if (loadType == LoadType.REFRESH) {
                    trendingDatabase.trendingDao().clearAll()
                }*/
                val gifEntities = trending.map { networkTrending ->
                    networkTrending.giphyItem.map { it.toGifEntity() }
                }.getOrNull() ?: emptyList()
                trendingDatabase.trendingDao().upsertAll(gifEntities)
            }
            MediatorResult.Success(
                endOfPaginationReached = trending.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}