package com.xingyun.android.home.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.xingyun.storage.data.dp.RecommendArticle
import com.xingyun.storage.data.repo.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RecommendArticleViewModel @Inject internal constructor(
    private val articleRepository: ArticleRepository
): ViewModel()  {




    fun loadArticles() : Flow<PagingData<RecommendArticle>> {
        return articleRepository.getRecommendArticles().cachedIn(viewModelScope)
    }

}