package com.alexesquerdo.giphy_app.database.converters


import androidx.room.TypeConverter
import com.alexesquerdo.giphy_app.domain.models.Analytics
import com.alexesquerdo.giphy_app.domain.models.Images
import com.alexesquerdo.giphy_app.domain.models.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class GiphyConverter {

    val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @TypeConverter
    fun analyticsToString(analytics: Analytics): String {
        val jsonAdapter = moshi.adapter(Analytics::class.java)
        return jsonAdapter.toJson(analytics)
    }

    @TypeConverter
    fun stringToAnalytics(analyticsString: String): Analytics {
        val jsonAdapter = moshi.adapter(Analytics::class.java)
        return jsonAdapter.fromJson(analyticsString)!!
    }

    @TypeConverter
    fun imagesToString(images: Images): String {
        val jsonAdapter = moshi.adapter(Images::class.java)
        return jsonAdapter.toJson(images)
    }

    @TypeConverter
    fun stringToImages(imagesString: String): Images {
        val jsonAdapter = moshi.adapter(Images::class.java)
        return jsonAdapter.fromJson(imagesString)!!
    }

    @TypeConverter
    fun userToString(user: User): String {
        val jsonAdapter = moshi.adapter(User::class.java)
        return jsonAdapter.toJson(user)
    }

    @TypeConverter
    fun stringToUser(userString: String): User {
        val jsonAdapter = moshi.adapter(User::class.java)
        return jsonAdapter.fromJson(userString)!!
    }
}