package com.xingyun.architecture.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.xingyun.architecture.R
import com.xingyun.architecture.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleBinding
    private lateinit var viewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article)
        initViewModel()
    }

    private fun initViewModel() {
        ViewModelProviders.of(this)
            .get(ArticleViewModel::class.java)
            .also {
                viewModel = it
                binding.viewModel = it
            }
            .run { loadArticle(123) }
    }

}