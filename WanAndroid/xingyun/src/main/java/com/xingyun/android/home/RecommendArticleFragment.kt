package com.xingyun.android.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.xingyun.android.databinding.FragmentRecommendArticleBinding
import com.xingyun.android.home.adapter.RecommendArticleAdapter
import com.xingyun.android.home.viewmodels.RecommendArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecommendArticleFragment : Fragment() {
    private var articleJob: Job? = null
    private lateinit var binding: FragmentRecommendArticleBinding
    private val viewModel: RecommendArticleViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecommendArticleBinding.inflate(inflater, container, false)

        val adapter = RecommendArticleAdapter()
        binding.rvRecommendArticle.adapter = adapter
        loadArticles(adapter)
        return binding.root
    }


    private fun loadArticles(adapter: RecommendArticleAdapter) {
        articleJob?.cancel()
        articleJob = lifecycleScope.launch {
            viewModel.loadArticles().collectLatest {
                adapter.submitData(it)
            }
        }
    }

}