package com.xingyun.storage.data.repo

import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.data.local.ILocalArticleDataSource
import com.xingyun.storage.data.remote.IRemoteArticleDataSource
import com.xingyun.storage.http.api.XResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val remoteArticleDataSource: IRemoteArticleDataSource,
    private val localArticleDataSource: ILocalArticleDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getArticle(): List<Article>? {
        val result = remoteArticleDataSource.getTopArticles()
        return if (result is XResult.Success) {
            withContext(ioDispatcher) {
                launch {
                    localArticleDataSource.updateArticle(result.data)
                }
            }
            result.data
        } else {
            null
        }
    }

}