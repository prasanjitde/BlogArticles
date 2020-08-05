package com.pd.blogarticles.service.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.pd.blogarticles.service.database.BoundaryCallback
import com.pd.blogarticles.service.database.LocalCache
import com.pd.blogarticles.service.models.ArticleEntityItem
import com.pd.blogarticles.service.network.ArticleApiService

class ArticleListRepository(
    private val localCache: LocalCache
) {

    companion object {
        private val TAG: String = ArticleListRepository::class.java.simpleName
        private const val DATABASE_PAGE_SIZE = 10
    }

    fun search(): LiveData<PagedList<ArticleEntityItem>> {

        // Get data source factory from the local cache
        val dataSourceFactory = localCache.articles()
        val boundaryCallback = BoundaryCallback(ArticleApiService, localCache)
        val networkErrors = boundaryCallback.networkErrors

        // Get the paged list

        return LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    /*fun getArticles(): MutableLiveData<ArticleEntity> {
        val articleEntity = MutableLiveData<ArticleEntity>()

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
    }*/
}