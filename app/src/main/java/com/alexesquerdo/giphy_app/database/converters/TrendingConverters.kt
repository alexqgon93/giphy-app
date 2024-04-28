package com.alexesquerdo.giphy_app.database.converters

import androidx.room.TypeConverter
import com.alexesquerdo.giphy_app.database.models.ImagesEntity
import com.alexesquerdo.giphy_app.domain.common.Measures
import com.alexesquerdo.giphy_app.domain.models.Images
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

internal class TrendingConverters {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromImages(images: ImagesEntity): String {
        val type = Types.newParameterizedType(ImagesEntity::class.java)
        val adapter = moshi.adapter<ImagesEntity>(type)
        return adapter.toJson(images)
    }

    @TypeConverter
    fun toImages(json: String): ImagesEntity {
        val type = Types.newParameterizedType(ImagesEntity::class.java)
        val adapter = moshi.adapter<ImagesEntity>(type)
        return adapter.fromJson(json)!!
    }

    @TypeConverter
    fun fromMeasure(measure: Measures): String {
        val type = Types.newParameterizedType(Measures::class.java)
        val adapter = moshi.adapter<Measures>(type)
        return adapter.toJson(measure)
    }

    @TypeConverter
    fun toMeasure(json: String): Measures {
        val type = Types.newParameterizedType(Measures::class.java)
        val adapter = moshi.adapter<Measures>(type)
        return adapter.fromJson(json)!!
    }

    @TypeConverter
    fun fromUrl(url: String): String {
        return url
    }

    @TypeConverter
    fun toUrl(url: String): String {
        return url
    }
}