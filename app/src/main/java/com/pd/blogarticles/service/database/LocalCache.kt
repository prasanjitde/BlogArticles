package com.pd.blogarticles.service.database

import android.util.Log
import androidx.paging.DataSource
import com.pd.blogarticles.service.models.ArticleEntityItem
import java.util.concurrent.Executor

class LocalCache(
    private val articleDao: ArticleDao,
    private val ioExecutor: Executor
) {

    fun insert(articles: ArticleEntityItem, insertFinished: () -> Unit) {
        ioExecutor.execute {
            Log.d("LocalCache", "inserting ${articles.id} id")
            articleDao.insert(articles)
            insertFinished()
        }
    }

    fun articles(): DataSource.Factory<Int, ArticleEntityItem> {
        return articleDao.getArticles()
    }
}