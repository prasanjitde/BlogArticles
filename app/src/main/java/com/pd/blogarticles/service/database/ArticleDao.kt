package com.pd.blogarticles.service.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pd.blogarticles.service.models.ArticleEntityItem

@Dao
interface ArticleDao {

    @Query("SELECT * from article_entity_table")
    fun getArticles(): DataSource.Factory<Int, ArticleEntityItem>

    // suspend will do this insertion in a separate thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(articleEntityItem: ArticleEntityItem): Long
}