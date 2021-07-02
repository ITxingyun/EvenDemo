package com.xingyun.storage.data.remote

import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.http.api.WebService
import com.xingyun.storage.http.api.XResult
import com.xingyun.storage.utils.apiCall

class RemoteArticleDataSource(
    private val service: WebService
) : IRemoteArticleDataSource {


    override suspend fun getTopArticles(): XResult<List<Article>> {
        return apiCall { service.getTopArticles() }
    }

}