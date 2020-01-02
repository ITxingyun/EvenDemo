package com.xingyun.evendemo.home

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentHomeBinding
import com.xingyun.evendemo.lifecycle.LifecycleFragment
import com.xingyun.evendemo.mvvm.LoginFragment
import com.xingyun.evendemo.picasso.PicassoFragment
import com.xingyun.evendemo.viewpage.ViewPage2Fragment
import com.xingyun.evendemo.window.WindowFragment

class HomeFragment : BaseFragment(),
    HomePagerAdapter.OnMainPagerItemClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun getFragmentTag(): String = "HomeFragment"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )
            .also { binding = it }
            .root

    override fun initData() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = HomePagerAdapter(getData(), this@HomeFragment)
        }
    }

    private fun getData(): List<BaseFragment> =
        listOf(
            LoginFragment(),
            PicassoFragment(),
            LifecycleFragment(),
            LoginFragment(),
            ViewPage2Fragment(),
            WindowFragment()
        )


    override fun onItemClick(fragment: BaseFragment) {
        (activity as MainActivity).replaceFragment(fragment)
    }
}