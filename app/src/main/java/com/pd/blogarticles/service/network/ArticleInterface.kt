package com.pd.blogarticles.service.network

import com.pd.blogarticles.service.models.ArticleEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleInterface {

    @GET("blogs?")
    fun getArticles(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Call<ArticleEntity>
}