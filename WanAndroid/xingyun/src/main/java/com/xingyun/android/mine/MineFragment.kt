package com.xingyun.android.mine

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.xingyun.android.article.ArticleViewModel
import com.xingyun.lib.base.BaseFragment

class MineFragment : BaseFragment() {
    private val viewModel by viewModels<ArticleViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadArticle()
    }
}