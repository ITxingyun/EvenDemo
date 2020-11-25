package com.xingyun.architecture.data

import com.xingyun.architecture.data.entity.Article
import com.xingyun.architecture.data.local.ILocalDataSource
import com.xingyun.architecture.data.remote.IRemoteDataSource

class DataRepository(
        private val remoteDataSource: IRemoteDataSource,
        private val localDataSource: ILocalDataSource
) {

    fun loadArticles(articleId: Int, isForceFetchData: Boolean = false): Article {
        return if (isForceFetchData) {
            getArticlesFromRemote(articleId)
        } else {
            val articles = localDataSource.getArticle(articleId)
            articles ?: getArticlesFromRemote(articleId)
        }
    }

    private fun getArticlesFromRemote(articleId: Int): Article {
        val article = remoteDataSource.getArticle(articleId)
        localDataSource.cacheArticle(article)
        return article
    }

}