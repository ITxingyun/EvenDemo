package com.xingyun.architecture.data.remote

import com.xingyun.architecture.data.entity.Article

interface IRemoteDataSource {
    fun getArticle(articleId: Int): Article
}