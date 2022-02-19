package com.xingyun.android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xingyun.android.data.entity.Article
import com.xingyun.android.data.entity.Rank
import com.xingyun.android.data.entity.TagsConverters

@Database(entities = [Article::class, Rank::class], version = 1)
@TypeConverters(TagsConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ArticleDao

}