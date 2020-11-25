package com.xingyun.architecture.data.model

import com.xingyun.architecture.ArticleItem
import com.xingyun.architecture.data.entity.Article

class ArticleModel : IModel {

    override fun articleToItem(article: Article): ArticleItem {
        return article.run { ArticleItem(title, content) }
    }
}