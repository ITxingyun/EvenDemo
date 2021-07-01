package com.xingyun.storage.data.local

import com.xingyun.storage.data.db.AppDatabase
import com.xingyun.storage.data.entity.Article
import javax.inject.Inject

class LocalArticleDataSource(private val appDatabase: AppDatabase) : ILocalArticleDataSource {


    override suspend fun updateArticle(articles: List<Article>) {
        appDatabase.userDao().insertAll(articles)
    }


}