package com.xingyun.android.article

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
class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    fun loadArticle(): Flow<PagingData<RecommendArticle>> {
        return articleRepository.getRecommendArticles().cachedIn(viewModelScope)
    }

}