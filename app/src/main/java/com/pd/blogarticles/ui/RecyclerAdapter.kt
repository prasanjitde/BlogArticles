package com.pd.blogarticles.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pd.blogarticles.R
import com.pd.blogarticles.service.models.ArticleEntityItem
import com.pd.blogarticles.utils.getFormattedNumber
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_list_row_item.view.*

class RecyclerAdapter() : PagedListAdapter<ArticleEntityItem, RecyclerView.ViewHolder>(DATA_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesHolder {
        return ArticlesHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = getItem(position)
        if(article != null){
            (holder as ArticlesHolder).bindArticle(article)
        }
    }

    class ArticlesHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private val username: TextView = v.username
        private val content: TextView = v.article_content
        private val title: TextView = v.title
        private val link: TextView = v.link
        private val avatar: ImageView = v.avatar
        private val articleImage: ImageView = v.article_image
        private val userDesignation: TextView = v.user_designation
        private val likes: TextView = v.likes
        private val comments: TextView = v.comments
        private val view = v

        override fun onClick(v: View?) {}

        fun bindArticle(articleEntityItem: ArticleEntityItem?) {
            if(articleEntityItem != null) {
                username.text = articleEntityItem.user[0].name
                userDesignation.text = articleEntityItem.user[0].designation
                content.text = articleEntityItem.content
                title.text = articleEntityItem.media[0].title
                link.text = articleEntityItem.media[0].url
                val longLikes = articleEntityItem.likes.toLong()
                val longComments = articleEntityItem.comments.toLong()
                likes.text = longLikes.getFormattedNumber() + " Likes"
                comments.text = longComments.getFormattedNumber() + " Comments"
                Picasso.with(view.context).load(articleEntityItem.user[0].avatar).into(avatar)
                Picasso.with(view.context).load(articleEntityItem.media[0].image).into(articleImage)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ArticlesHolder {
                return ArticlesHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_list_row_item, parent, false))

                // return ArticlesHolder(parent.inflate(R.layout.article_list_row_item, false))
            }
        }
    }

    companion object {
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<ArticleEntityItem>() {
            override fun areItemsTheSame(oldItem: ArticleEntityItem, newItem: ArticleEntityItem): Boolean =
                oldItem.createdAt == newItem.createdAt

            override fun areContentsTheSame(oldItem: ArticleEntityItem, newItem: ArticleEntityItem): Boolean =
                oldItem == newItem
        }
    }

}