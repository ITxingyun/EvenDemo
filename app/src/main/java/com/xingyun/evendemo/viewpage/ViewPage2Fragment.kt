package com.xingyun.evendemo.viewpage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentViewPageBinding

class ViewPage2Fragment : BaseFragment() {
    private lateinit var binding: FragmentViewPageBinding
    private lateinit var pageChangeCallback: ViewPager2.OnPageChangeCallback

    override fun getFragmentTag(): String = "ViewPage2Fragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentViewPageBinding>(inflater, R.layout.fragment_view_page, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val pages = listOf("page one", "page tow", "page three", "page four", "page five")
        binding.vpSimple.apply {
            adapter = SimplePageAdapter(pages)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    Log.e("wen", "onPageScrollStateChanged: state ->  $state")
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    Log.e("wen", "onPageScrolled: position -> $position")
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.e("wen", "onPageSelected: position -> $position")
                }
            }.also { pageChangeCallback = it })
            setPageTransformer(ViewPager2PageTransformation())
        }

        binding.vpFragment.apply {
            adapter = FragmentPageAdapter(this@ViewPage2Fragment)
        }
        TabLayoutMediator(binding.tabLayout, binding.vpFragment) {tab,position ->
            tab.text = "Page ${(position + 1)}"
        }.attach()
    }

    override fun onDestroy() {
        binding.vpSimple.unregisterOnPageChangeCallback(pageChangeCallback)
        super.onDestroy()
    }

    class ViewPager2PageTransformation : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            when {
                position < -1 ->
                    page.alpha = 0.1f
                position <= 1 -> {
                    page.alpha = Math.max(0.2f, 1 - Math.abs(position))
                }
                else -> page.alpha = 0.1f
            }
        }
    }

}