package com.xingyun.android.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xingyun.storage.data.repo.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    fun loadArticle() {
        viewModelScope.launch {
            val result = articleRepository.getArticle()
            if (result.isSuccess) {
                result.getOrNull()
            }
        }

    }

}