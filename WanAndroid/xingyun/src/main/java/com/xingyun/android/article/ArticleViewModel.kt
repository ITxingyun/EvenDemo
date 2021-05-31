package com.xingyun.android.article

import androidx.lifecycle.ViewModel
import com.xingyun.storage.data.repo.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {


}