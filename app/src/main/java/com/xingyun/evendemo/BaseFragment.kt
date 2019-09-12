package com.xingyun.evendemo

import android.os.Bundle
import android.widget.Toast

abstract class BaseFragment : androidx.fragment.app.Fragment() {

    abstract fun getFragmentTag(): String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    open fun initData() = Unit

    fun showMessage(message: String) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }
}