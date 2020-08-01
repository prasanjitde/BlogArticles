package com.pd.blogarticles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pd.blogarticles.R

/**
 * Created by Prasanjit on 2020-06-31.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openArticleFragment()
    }

    private fun openArticleFragment(){
        supportFragmentManager.beginTransaction()
                .add(R.id.articleLayout, ArticleListFragment.newInstance(), "article_list_fragment").commit()
    }
}
