package com.xingyun.architecture.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xingyun.architecture.data.DataRepository

class ArticleViewModel(
        private val dataRepository: DataRepository
) : ViewModel() {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    fun loadArticle(articleId: Int) {
        _title.value = dataRepository.loadArticles(articleId).title
    }

}