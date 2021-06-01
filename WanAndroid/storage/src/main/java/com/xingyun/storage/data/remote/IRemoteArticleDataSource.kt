package com.xingyun.storage.data.remote

import com.xingyun.storage.data.entity.Article

interface IRemoteArticleDataSource {
    suspend fun getTopArticles(): Result<List<Article>>
}