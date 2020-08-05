package com.pd.blogarticles.service.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.pd.blogarticles.service.models.ArticleEntityItem
import com.pd.blogarticles.service.network.ArticleApiService
import com.pd.blogarticles.service.network.searchRepos

class BoundaryCallback(
    private val service: ArticleApiService,
    private val cache: LocalCache
) : PagedList.BoundaryCallback<ArticleEntityItem>() {

    private var lastRequestedPage = 1

    private val _networkErrors = MutableLiveData<String>()

    val networkErrors: LiveData<String>
        get() = _networkErrors

    private var isRequestInProgress = false

    companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }

    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        isRequestInProgress = true
        searchRepos(service, lastRequestedPage, NETWORK_PAGE_SIZE, { articles ->
            cache.insert(articles) {
                lastRequestedPage++
                isRequestInProgress = false
            }
        }, { error ->
            _networkErrors.postValue(error)
            isRequestInProgress = false
        })
    }


    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: ArticleEntityItem) {
        requestAndSaveData()
    }
}