package com.xingyun.architecture.data.local

import com.xingyun.architecture.data.entity.Article

interface ILocalDataSource {
    fun cacheArticle(article: Article)

    fun getArticle(id: Int): Article?
}