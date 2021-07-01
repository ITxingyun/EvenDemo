package com.xingyun.storage.data.remote

import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.http.api.XResult

interface IRemoteArticleDataSource {
    suspend fun getTopArticles(): XResult<List<Article>>
}