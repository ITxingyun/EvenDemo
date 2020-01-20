package com.xingyun.evendemo.opensoruce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.common.ProjectAdapter
import com.xingyun.evendemo.databinding.FragmentOpenSourceBinding
import com.xingyun.evendemo.opensoruce.http.okhttp.OkHttpFragment
import com.xingyun.evendemo.opensoruce.image.picasso.PicassoFragment

class OpenSourceFragment : BaseFragment(),
        ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentOpenSourceBinding
    override fun getFragmentTag(): String = "Bug"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentOpenSourceBinding>(inflater, R.layout.fragment_open_source, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments= listOf(
                OkHttpFragment(),
                PicassoFragment()
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProjectAdapter(fragments, this@OpenSourceFragment)
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}