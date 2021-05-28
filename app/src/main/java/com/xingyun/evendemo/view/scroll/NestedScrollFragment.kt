package com.xingyun.evendemo.view.scroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentNestedScrollBinding

class NestedScrollFragment : BaseFragment() {
    private lateinit var binding: FragmentNestedScrollBinding

    override val toolbarTitle: String = "嵌套滑动"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentNestedScrollBinding.inflate(inflater, container, false)
            .also { binding = it }
            .root
}