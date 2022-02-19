package com.xingyun.android.data.local

import com.xingyun.android.data.db.AppDatabase
import com.xingyun.android.data.entity.Article

class LocalArticleDataSource(private val appDatabase: AppDatabase) : ILocalArticleDataSource {


    override suspend fun updateArticle(articles: List<Article>) {
        appDatabase.userDao().insertAll(articles)
    }

    override suspend fun selectArticle(id: Int): Article {
        return appDatabase.userDao().selectArticle(id)
    }
}