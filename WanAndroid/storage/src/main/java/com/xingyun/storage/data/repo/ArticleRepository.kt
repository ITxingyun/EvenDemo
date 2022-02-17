package com.xingyun.storage.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.xingyun.storage.data.dp.RecommendArticle
import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.data.local.ILocalArticleDataSource
import com.xingyun.storage.data.remote.RecommendArticlePagingSource
import com.xingyun.storage.http.api.WebService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val service: WebService
) {

    fun getRecommendArticles(): Flow<PagingData<RecommendArticle>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { RecommendArticlePagingSource(service) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 25
    }

}