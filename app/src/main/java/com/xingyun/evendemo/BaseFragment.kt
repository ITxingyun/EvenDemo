package com.xingyun.evendemo

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract fun getFragmentTag(): String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    abstract fun initData()
}