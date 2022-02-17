package com.xingyun.android.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xingyun.android.home.RecommendArticleFragment
import com.xingyun.android.home.SquareFragment

const val RECOMMEND_ARTICLE_PAGE_INDEX = 0
const val SQUARE_PAGE_INDEX = 1

class HomePageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        RECOMMEND_ARTICLE_PAGE_INDEX to { RecommendArticleFragment() },
        SQUARE_PAGE_INDEX to { SquareFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}