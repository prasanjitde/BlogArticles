package com.pd.blogarticles.service.models

data class Media(
    val blogId: String,
    val createdAt: String,
    val id: String,
    val image: String,
    val title: String,
    val url: String
)