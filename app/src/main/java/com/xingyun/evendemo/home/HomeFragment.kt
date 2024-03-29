package com.xingyun.evendemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.bug.BugFragment
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.components.ComponentFragment
import com.xingyun.evendemo.databinding.FragmentHomeBinding
import com.xingyun.evendemo.framework.FrameWorkFragment
import com.xingyun.evendemo.other.OtherFragment
import com.xingyun.evendemo.view.ViewFragment

class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    override val toolbarTitle: String = "星云学习Demo"
    override val hasToolbar: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
                    .also { binding = it }
                    .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnView.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(ViewFragment())
        }
        binding.btnFrameWork.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(FrameWorkFragment())
        }

        binding.btnBug.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(BugFragment())
        }

        binding.btnOther.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(OtherFragment())
        }

        binding.btnComponent.setOnClickListener {
            obtainViewModel()?.replaceFragmentToActivity(ComponentFragment())
        }

        binding.btnStyle.setOnClickListener {

        }
    }
}