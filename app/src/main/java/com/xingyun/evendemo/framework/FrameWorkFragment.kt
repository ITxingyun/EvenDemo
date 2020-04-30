package com.xingyun.evendemo.framework

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseFragment
import com.xingyun.library.base.adapter.ProjectAdapter
import com.xingyun.evendemo.databinding.FragmentFrameWorkBinding
import com.xingyun.evendemo.framework.launchmode.StandardActivity
import com.xingyun.evendemo.framework.lifecycle.LifecycleFragment
import com.xingyun.evendemo.framework.window.WindowFragment

class FrameWorkFragment : BaseFragment(),
        ProjectAdapter.OnViewItemClickListener {
    private lateinit var binding: FragmentFrameWorkBinding

    override val toolbarTitle: String = "源码分析"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentFrameWorkBinding>(inflater, R.layout.fragment_frame_work, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val fragments= listOf(
                LifecycleFragment(),
                WindowFragment()
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProjectAdapter(
                fragments,
                this@FrameWorkFragment
            )
        }
        binding.btnActivityLifecycle.setOnClickListener {
            val intent = Intent(context, StandardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onItemClick(fragment: BaseFragment) {
        obtainViewModel()?.replaceFragmentToActivity(fragment)
    }
}