package com.xingyun.android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.xingyun.android.R
import com.xingyun.android.adapter.FragmentPageAdapter
import com.xingyun.android.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        val fragments = listOf(
            FragmentPageAdapter.PagerTab(::RecommendArticleFragment),
            FragmentPageAdapter.PagerTab(::SquareFragment)
        )
        viewPager.adapter = FragmentPageAdapter(this, fragments)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }


    private fun getTabTitle(position: Int): String? {
        return when (position) {
            RECOMMEND_ARTICLE_PAGE_INDEX -> getString(R.string.home_tab_recommend)
            SQUARE_PAGE_INDEX -> getString(R.string.home_tab_square)
            else -> null
        }
    }

    companion object {
        private const val RECOMMEND_ARTICLE_PAGE_INDEX = 0
        private const val SQUARE_PAGE_INDEX = 1
    }
}