package com.xingyun.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.xingyun.android.adapter.FragmentPageAdapter
import com.xingyun.android.databinding.FragmentMainBinding
import com.xingyun.android.ui.home.HomeFragment
import com.xingyun.android.ui.mine.MineFragment
import com.xingyun.android.ui.project.ProjectFragment

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPager
        val bottomNavView = binding.bottomNavView

        val fragments = listOf(
            FragmentPageAdapter.PagerTab(::HomeFragment),
            FragmentPageAdapter.PagerTab(::MineFragment),
            FragmentPageAdapter.PagerTab(::ProjectFragment),
        )
        viewPager.adapter = FragmentPageAdapter(this, fragments)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavView.menu.getItem(position).isChecked = true
            }
        })

        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_dest -> viewPager.setCurrentItem(0, true)
                R.id.project_dest -> viewPager.setCurrentItem(1, true)
                R.id.mine_dest -> viewPager.setCurrentItem(2, true)
            }
            true
        }
        return binding.root
    }
}