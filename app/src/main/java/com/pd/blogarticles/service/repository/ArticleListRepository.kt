package com.pd.blogarticles.service.repository

import androidx.lifecycle.MutableLiveData
import com.pd.blogarticles.service.models.ArticleEntity
import com.pd.blogarticles.service.network.ArticleApiService.articleInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Prasanjit on 2020-06-31.
 */
class ArticleListRepository {

    companion object {
        private val TAG: String = ArticleListRepository::class.java.simpleName
    }

    fun getArticles(): MutableLiveData<ArticleEntity> {
        val articleEntity = MutableLiveData<ArticleEntity>()

        articleInterface.getArticles(1, 10).enqueue(object : Callback<ArticleEntity> {
            override fun onResponse(call: Call<ArticleEntity>, response: Response<ArticleEntity>) {
                if (response.isSuccessful) {
                    articleEntity.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArticleEntity>, t: Throwable) {
                // no data
                articleEntity.value = null
            }

        })

        return articleEntity
    }
}