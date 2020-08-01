package com.pd.blogarticles.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pd.blogarticles.service.models.ArticleEntity
import com.pd.blogarticles.service.repository.ArticleListRepository

/**
 * Created by Prasanjit on 2020-06-31.
 */
class ArticleListViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    private val articleListRepository: ArticleListRepository = ArticleListRepository()

    fun getArticle(): MutableLiveData<ArticleEntity> {
        return articleListRepository.getArticles()
    }

}
