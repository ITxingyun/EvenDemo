package com.xingyun.evendemo.view.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentCustomViewBinding

class CustomViewFragment : BaseFragment() {
    private lateinit var binding: FragmentCustomViewBinding

    override val toolbarTitle: String = "自定义控件"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentCustomViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


}