package com.xingyun.android.data.remote

import com.xingyun.android.data.entity.Article
import com.xingyun.android.http.api.XResult

interface IRemoteArticleDataSource {
    suspend fun getTopArticles(): XResult<List<Article>>
}