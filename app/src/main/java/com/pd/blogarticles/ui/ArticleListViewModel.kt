package com.pd.blogarticles.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.pd.blogarticles.service.database.ArticleDao
import com.pd.blogarticles.service.database.ArticleDatabase
import com.pd.blogarticles.service.database.LocalCache
import com.pd.blogarticles.service.models.ArticleEntityItem
import com.pd.blogarticles.service.repository.ArticleListRepository
import java.util.concurrent.Executors

class ArticleListViewModel(application: Application) : AndroidViewModel(application) {

    // should be injected here
    private val articleListRepository: ArticleListRepository
    private val localCache: LocalCache

    init {
        val articleDao: ArticleDao = ArticleDatabase.getDatabase(application).articleDao()
        localCache = LocalCache(articleDao, Executors.newSingleThreadExecutor())
        articleListRepository = ArticleListRepository(localCache)
    }

    fun getArticle(): LiveData<PagedList<ArticleEntityItem>> {
        return articleListRepository.search()
    }
}
