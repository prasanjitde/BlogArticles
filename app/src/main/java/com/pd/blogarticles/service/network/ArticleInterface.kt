package com.pd.blogarticles.service.network

import android.util.Log
import com.pd.blogarticles.service.models.ArticleEntity
import com.pd.blogarticles.service.models.ArticleEntityItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val TAG = "ArticleInterface"
fun searchRepos(
    service: ArticleApiService,
    page: Int,
    itemsPerPage: Int,
    onSuccess: (articles: ArticleEntityItem) -> Unit,
    onError: (error: String) -> Unit
) {
    Log.d("", "page: $page, itemsPerPage: $itemsPerPage")

    service.articleInterface.getArticles(page, itemsPerPage).enqueue(
        object : Callback<ArticleEntity> {
            override fun onFailure(call: Call<ArticleEntity>?, t: Throwable) {
                Log.d(TAG, "fail to get data ${t.localizedMessage} ${call?.request()?.url().toString()}")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<ArticleEntity>?,
                response: Response<ArticleEntity>
            ) {
                Log.d(TAG, "got a response $response")
                if (response.isSuccessful) {
                    val articleEntity: ArticleEntity? = response.body()
                    if(articleEntity != null) {
                        for (item in articleEntity) {
                            articleEntity?.let { onSuccess(item) }
                        }
                    }
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}

interface ArticleInterface {

    @GET("blogs?")
    fun getArticles(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Call<ArticleEntity>
}