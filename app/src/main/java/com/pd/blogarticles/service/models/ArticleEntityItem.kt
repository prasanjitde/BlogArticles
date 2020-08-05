package com.pd.blogarticles.service.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_entity_table")
data class ArticleEntityItem(
    @PrimaryKey(autoGenerate = true)
    val articleId: Int,

    val comments: Int,
    val content: String,
    val createdAt: String,
    val id: String,
    val likes: Int,
    val media: List<Media>,
    val user: List<User>
)