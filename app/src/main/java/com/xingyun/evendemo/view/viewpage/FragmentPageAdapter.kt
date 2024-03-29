package com.xingyun.evendemo.view.viewpage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(fragment: Fragment, private val fragments: List<PagerTab>) : FragmentStateAdapter(fragment.childFragmentManager, fragment.viewLifecycleOwner.lifecycle) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position].pagerGenerator()

    class PagerTab(val pagerGenerator: () -> Fragment)
}