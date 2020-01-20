package com.xingyun.evendemo.home

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.xingyun.evendemo.R
import com.xingyun.evendemo.bug.BugFragment
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.databinding.FragmentHomeBinding
import com.xingyun.evendemo.common.FragmentPageAdapter
import com.xingyun.evendemo.framework.FrameWorkFragment
import com.xingyun.evendemo.opensoruce.OpenSourceFragment
import com.xingyun.evendemo.view.ViewFragment

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun getFragmentTag(): String = "HomeFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments = listOf<BaseFragment>(
                ViewFragment(),
                BugFragment(),
                FrameWorkFragment(),
                OpenSourceFragment()
        )
        binding.vpMainPage.apply {
            adapter = FragmentPageAdapter(this@HomeFragment, fragments)
        }

        TabLayoutMediator(binding.tabLayout, binding.vpMainPage) { tab, position ->
            tab.text = fragments[position].getFragmentTag()
        }.attach()
    }
}