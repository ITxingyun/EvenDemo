package com.xingyun.android.mine

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.xingyun.android.R
import com.xingyun.android.article.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MineFragment : Fragment(R.layout.fragment_mine) {
    private val viewModel by viewModels<ArticleViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadArticle()
    }
}