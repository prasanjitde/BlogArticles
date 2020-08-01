package com.pd.blogarticles.service.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ArticleApiService {

    // still keeping this as lazy but is not required
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val articleInterface: ArticleInterface = retrofit.create(ArticleInterface::class.java)
}