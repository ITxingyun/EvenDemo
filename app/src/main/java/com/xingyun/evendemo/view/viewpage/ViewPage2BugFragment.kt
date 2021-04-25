package com.xingyun.evendemo.view.viewpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentViewPageBugBinding
import com.xingyun.evendemo.view.custom.CustomViewFragment
import com.xingyun.evendemo.view.menu.MenuFragment
import com.xingyun.evendemo.view.recyclerview.RecyclerViewFeaturesFragment
import com.xingyun.evendemo.view.shareelement.ShareElementFragment

class ViewPage2BugFragment : BaseFragment() {
    private lateinit var binding: FragmentViewPageBugBinding
    override val toolbarTitle: String = "ViewPage2Bug"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentViewPageBugBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments = listOf(
            FragmentPageAdapter.PagerTab(::PagerBugFragment),
            FragmentPageAdapter.PagerTab(::PageFragment),
            FragmentPageAdapter.PagerTab(::MenuFragment),
            FragmentPageAdapter.PagerTab(::ShareElementFragment),
            FragmentPageAdapter.PagerTab(::CustomViewFragment),
            FragmentPageAdapter.PagerTab(::RecyclerViewFeaturesFragment))
        binding.vpFragment.adapter = FragmentPageAdapter(this@ViewPage2BugFragment, fragments)
        TabLayoutMediator(binding.tabLayout, binding.vpFragment) {tab,position ->
            tab.text = "a Page ${(position + 1)}"
        }.attach()
    }



}