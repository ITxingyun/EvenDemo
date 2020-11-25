package com.xingyun.architecture.data.model

import com.xingyun.architecture.ArticleItem
import com.xingyun.architecture.data.entity.Article

interface IModel {
    //假设Article是一个数据结构很复杂的对象
    fun articleToItem(article: Article): ArticleItem
}