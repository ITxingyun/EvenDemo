package com.xingyun.evendemo.framework.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.library.base.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentLifecycleBinding

class LifecycleFragment : BaseFragment(), Navigator {

    override val toolbarTitle: String = "Fragment生命周期"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("LifecycleFragment EvenDemo--->", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LifecycleFragment EvenDemo--->", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("LifecycleFragment EvenDemo--->", "onCreateView")
        return DataBindingUtil.inflate<FragmentLifecycleBinding>(inflater, R.layout.fragment_lifecycle, container, false).apply {
            navigator = this@LifecycleFragment
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("LifecycleFragment EvenDemo--->", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("LifecycleFragment EvenDemo--->", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LifecycleFragment EvenDemo--->", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifecycleFragment EvenDemo--->", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifecycleFragment EvenDemo--->", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("LifecycleFragment EvenDemo--->", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifecycleFragment EvenDemo--->", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("LifecycleFragment EvenDemo--->", "onDetach")
    }

    override fun addFragment() {
        obtainViewModel()?.addFragmentToActivity(AddFragment())
    }

    override fun replaceFragment() {
        obtainViewModel()?.replaceFragmentToActivity(ReplaceFragment())
    }
}

interface Navigator {
    fun addFragment()

    fun replaceFragment()
}
