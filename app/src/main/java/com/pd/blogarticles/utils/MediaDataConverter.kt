package com.pd.blogarticles.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pd.blogarticles.service.models.Media
import com.pd.blogarticles.service.models.User
import java.io.Serializable

class MediaDataConverter : Serializable {
    @TypeConverter
    fun fromWeatherList(mediaList: List<Media>?): String? {
        if (mediaList == null) {
            return null
        }

        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {}.type
        return gson.toJson(mediaList, type)
    }

    @TypeConverter
    fun toWeatherList(mediaList: String?): List<Media>? {
        if (mediaList == null) {
            return emptyList()
        }

        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {}.type
        return gson.fromJson(mediaList, type)
    }
}