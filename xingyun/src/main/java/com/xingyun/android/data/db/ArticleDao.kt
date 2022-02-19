package com.xingyun.android.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.xingyun.android.data.entity.Article

@Dao
interface ArticleDao {
    @Insert
    fun insert(vararg article: Article)

    @Insert
    fun insertAll(articles: List<Article>)

    @Delete
    fun delete(article: Article)

    @Query("select *from article where id == :id")
    fun selectArticle(id: Int): Article
}