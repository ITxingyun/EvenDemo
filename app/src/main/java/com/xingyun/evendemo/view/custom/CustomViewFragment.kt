package com.xingyun.evendemo.view.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentCustomViewBinding
import com.xingyun.evendemo.view.custom.view.FilterFlowAdapter

class CustomViewFragment : BaseFragment() {
    private lateinit var binding: FragmentCustomViewBinding

    override val toolbarTitle: String = "自定义控件"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentCustomViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filter.update(listOf(
                "aaaaaa", "bbbbbbbbbb", "cccccc", "ddddd" ,"eeeeee", "fffff","aaaaaaa", "bbbbbbbbabb", "ccccccs", "dddddxd" ,"esaeeeee", "fffaaff",
                "hhhhhhhhhhhhhh", "iiiiiiiiiiiiiiiiiiii", "aaaaaiiiiiiiiiiiiiiiiiiii", "aaassssiiiiiiiiiiiiiiiiiiii"
        ))
    }

}