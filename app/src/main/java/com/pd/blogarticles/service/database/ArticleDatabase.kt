package com.pd.blogarticles.service.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pd.blogarticles.service.models.ArticleEntityItem
import com.pd.blogarticles.service.models.Media
import com.pd.blogarticles.service.models.User
import com.pd.blogarticles.utils.MediaDataConverter
import com.pd.blogarticles.utils.UserDataConverter

@Database(
    entities = [ArticleEntityItem::class, Media::class, User::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(UserDataConverter::class, MediaDataConverter::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getDatabase(
            context: Context
        ): ArticleDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,
                    "article_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}