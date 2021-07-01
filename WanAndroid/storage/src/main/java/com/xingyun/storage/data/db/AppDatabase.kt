package com.xingyun.storage.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.data.entity.Rank
import com.xingyun.storage.data.entity.TagsConverters

@Database(entities = [Article::class], version = 1)
@TypeConverters(TagsConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ArticleDao

}