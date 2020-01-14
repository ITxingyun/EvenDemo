package com.xingyun.evendemo.view.viewpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentPageBinding

class PageFragment: BaseFragment() {

    override fun getFragmentTag(): String = "PageFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentPageBinding>(inflater, R.layout.fragment_page, container, false)
                    .root
}