package com.xingyun.android.data.remote

import com.xingyun.android.data.entity.Article
import com.xingyun.android.http.api.WebService
import com.xingyun.android.http.api.XResult
import com.xingyun.android.utils.apiCall

class RemoteArticleDataSource(
    private val service: WebService
) : IRemoteArticleDataSource {


    override suspend fun getTopArticles(): XResult<List<Article>> {
        return apiCall { service.getTopArticles() }
    }

}