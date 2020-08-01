package com.pd.blogarticles.service.models

data class ArticleEntityItem(
    val comments: Int,
    val content: String,
    val createdAt: String,
    val id: String,
    val likes: Int,
    val media: List<Media>,
    val user: List<User>
)