package com.xingyun.evendemo.view.viewpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentPageBugBinding

class PagerBugFragment: BaseFragment() {

    private lateinit var binding: FragmentPageBugBinding
    override val toolbarTitle: String = "ViewPage2Bug"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentPageBugBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root


}