package com.xingyun.storage.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xingyun.storage.data.dp.RecommendArticle
import com.xingyun.storage.data.entity.Article
import com.xingyun.storage.http.api.WebService

class RecommendArticlePagingSource(
    private val service: WebService
) : PagingSource<Int, RecommendArticle>() {

    override fun getRefreshKey(state: PagingState<Int, RecommendArticle>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecommendArticle> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = service.getRecommendArticles(page)
            val articles = response.data.datas.map {
                RecommendArticle(
                    id = it.id,
                    title = it.title,
                    link = it.link,
                    author = it.author,
                    desc = it.desc,
                    niceShareDate = it.niceShareDate
                )
            }
            LoadResult.Page(
                data = articles,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.data.total) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val UNSPLASH_STARTING_PAGE_INDEX = 1
    }
}