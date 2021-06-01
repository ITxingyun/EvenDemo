package com.xingyun.storage.data.remote

import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.http.api.WebService

class RemoteArticleDataSource constructor(
        private val service: WebService
) : IRemoteArticleDataSource {


    override suspend fun getTopArticles(): Result<List<Article>> {
        return service.getTopArticles()
    }

}