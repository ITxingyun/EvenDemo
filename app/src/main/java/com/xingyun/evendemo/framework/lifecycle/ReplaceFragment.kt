package com.xingyun.evendemo.framework.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.databinding.FragmentReplaceBinding

class ReplaceFragment : BaseFragment() {

    override fun getFragmentTag(): String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("ReplaceFragment EvenDemo--->", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ReplaceFragment EvenDemo--->", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("ReplaceFragment EvenDemo--->", "onCreateView")
        return DataBindingUtil.inflate<FragmentReplaceBinding>(
            inflater,
            R.layout.fragment_replace,
            container,
            false
        ).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("ReplaceFragment EvenDemo--->", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("ReplaceFragment EvenDemo--->", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ReplaceFragment EvenDemo--->", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("ReplaceFragment EvenDemo--->", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("ReplaceFragment EvenDemo--->", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("ReplaceFragment EvenDemo--->", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ReplaceFragment EvenDemo--->", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("ReplaceFragment EvenDemo--->", "onDetach")
    }
}