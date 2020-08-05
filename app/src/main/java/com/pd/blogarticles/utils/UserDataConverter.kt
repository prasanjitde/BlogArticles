package com.pd.blogarticles.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pd.blogarticles.service.models.User
import java.io.Serializable

class UserDataConverter : Serializable {
    @TypeConverter
    fun fromWeatherList(userList: List<User>?): String? {
        if (userList == null) {
            return null
        }

        val gson = Gson()
        val type = object : TypeToken<List<User>>() {}.type
        return gson.toJson(userList, type)
    }

    @TypeConverter
    fun toWeatherList(userList: String?): List<User>? {
        if (userList == null) {
            return emptyList()
        }

        val gson = Gson()
        val type = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(userList, type)
    }
}