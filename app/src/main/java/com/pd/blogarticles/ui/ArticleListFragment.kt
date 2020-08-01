package com.pd.blogarticles.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.pd.blogarticles.R
import com.pd.blogarticles.service.models.ArticleEntityItem

/**
 * Created by Prasanjit on 2020-06-31.
 */
class ArticleListFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleListFragment()
    }

    private lateinit var viewModel: ArticleListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArticleListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getArticle().observe(viewLifecycleOwner, Observer {
            val articleEntityItem = it[0]
        })
    }

}
