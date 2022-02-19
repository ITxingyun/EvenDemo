package com.xingyun.android.data.local

import com.xingyun.android.data.entity.Article

interface ILocalArticleDataSource {

    suspend fun updateArticle(articles: List<Article>)

    suspend fun selectArticle(id: Int): Article


}