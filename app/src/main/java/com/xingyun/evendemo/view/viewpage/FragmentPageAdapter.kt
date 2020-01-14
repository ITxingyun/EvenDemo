package com.xingyun.evendemo.view.viewpage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = listOf(PageFragment(), PageFragment(), PageFragment(), PageFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}