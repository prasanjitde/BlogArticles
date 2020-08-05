package com.pd.blogarticles.service.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,

    val about: String,
    val avatar: String,
    val blogId: String,
    val city: String,
    val createdAt: String,
    val designation: String,
    val id: String,
    val lastname: String,
    val name: String
)