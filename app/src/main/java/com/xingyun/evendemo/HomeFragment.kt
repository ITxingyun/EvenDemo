package com.xingyun.evendemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.databinding.FragmentHomeBinding
import com.xingyun.evendemo.livedata.LiveDataFragment

class HomeFragment : BaseFragment(), MainPagerAdapter.OnMainPagerItemClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun getFragmentTag(): String = "HomeFragment"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
                    .also { binding = it }
                    .root

    override fun initData() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MainPagerAdapter(getData(), this@HomeFragment)
        }
    }

    private fun getData(): List<BaseFragment> =
            listOf(
                    LiveDataFragment(),
                    LiveDataFragment(),
                    LiveDataFragment(),
                    LiveDataFragment()
            )


    override fun onItemClick(fragment: BaseFragment) {
        (activity as MainActivity).replaceFragment(fragment)
    }
}