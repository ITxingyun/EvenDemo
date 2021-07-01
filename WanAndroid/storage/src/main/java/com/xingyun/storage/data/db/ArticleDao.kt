package com.xingyun.storage.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.xingyun.storage.data.entity.Article

@Dao
interface ArticleDao {
    @Insert
    fun insert(vararg article: Article)

    @Insert
    fun insertAll(articles: List<Article>)

    @Delete
    fun delete(article: Article)
}