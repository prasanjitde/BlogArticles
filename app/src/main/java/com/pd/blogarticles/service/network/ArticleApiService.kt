package com.pd.blogarticles.service.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ArticleApiService {

    // still keeping this as lazy but is not required
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://5e99a9b1bc561b0016af3540.mockapi.io/jet2/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val articleInterface: ArticleInterface = retrofit.create(ArticleInterface::class.java)
}