package com.pd.blogarticles.ui

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pd.blogarticles.R
import com.pd.blogarticles.service.models.ArticleEntityItem
import com.pd.blogarticles.utils.inflate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_list_row_item.view.*

class RecyclerAdapter() :
    RecyclerView.Adapter<RecyclerAdapter.ArticlesHolder>() {
    private lateinit var articleEntityItem: ArrayList<ArticleEntityItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesHolder {
        return ArticlesHolder(parent.inflate(R.layout.article_list_row_item, false))
    }

    fun populateList(articleEntityItem: ArrayList<ArticleEntityItem>){
        this.articleEntityItem = articleEntityItem
        notifyDataSetChanged()
    }

    override fun getItemCount() = articleEntityItem.size

    override fun onBindViewHolder(holder: ArticlesHolder, position: Int) {
        val article = articleEntityItem[position]
        holder.bindArticle(article)
    }

    class ArticlesHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private val username: TextView = v.username
        private val content: TextView = v.article_content
        private val title: TextView = v.title
        private val link: TextView = v.link
        private val avatar: ImageView = v.avatar
        private val articleImage: ImageView = v.article_image
        private val userDesignation: TextView = v.user_designation
        private val view = v

        override fun onClick(v: View?) {}

        fun bindArticle(articleEntityItem: ArticleEntityItem) {
            username.text = articleEntityItem.user[0].name
            userDesignation.text = articleEntityItem.user[0].designation
            content.text = articleEntityItem.content
            title.text = articleEntityItem.media[0].title
            link.text = articleEntityItem.media[0].url
            Picasso.with(view.context).load(articleEntityItem.user[0].avatar).into(avatar)
            Picasso.with(view.context).load(articleEntityItem.media[0].image).into(articleImage)
        }
    }

}