package com.pd.blogarticles.service.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "media_table")
data class Media(

    @PrimaryKey(autoGenerate = true)
    val mediaId: Int,

    val blogId: String,
    val createdAt: String,
    val id: String,
    val image: String,
    val title: String,
    val url: String
)