package com.xingyun.storage.data.local

import com.xingyun.storage.data.entity.Article

interface ILocalArticleDataSource {

    suspend fun updateArticle(articles: List<Article>)

}