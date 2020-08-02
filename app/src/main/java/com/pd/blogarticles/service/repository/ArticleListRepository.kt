package com.pd.blogarticles.service.repository

import android.util.Log
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

        /*val response = articleInterface.getArticles(1, 10).execute()

        if (response.isSuccessful){
            articleEntity.value = response.body()
        } else articleEntity.value = null*/

        articleInterface.getArticles(1, 10).enqueue(object : Callback<ArticleEntity> {
            override fun onResponse(call: Call<ArticleEntity>, response: Response<ArticleEntity>) {
                Log.i(TAG, call.request().url().toString())
                if (response.isSuccessful) {
                    articleEntity.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArticleEntity>, t: Throwable) {
                // no data
                Log.i(TAG, call.request().url().toString())
                Log.e(TAG, t.localizedMessage)
                articleEntity.value = null
            }

        })

        return articleEntity
    }
}