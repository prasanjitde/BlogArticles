package com.pd.blogarticles.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pd.blogarticles.R

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
