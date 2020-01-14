package com.xingyun.evendemo.fragment.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.databinding.FragmentAddBinding

class AddFragment : BaseFragment() {
    override fun getFragmentTag(): String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("AddFragment EvenDemo--->", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("AddFragment EvenDemo--->", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("AddFragment EvenDemo--->", "onCreateView")
        return DataBindingUtil.inflate<FragmentAddBinding>(
            inflater,
            R.layout.fragment_add,
            container,
            false
        ).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("AddFragment EvenDemo--->", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("AddFragment EvenDemo--->", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("AddFragment EvenDemo--->", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("AddFragment EvenDemo--->", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("AddFragment EvenDemo--->", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("AddFragment EvenDemo--->", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("AddFragment EvenDemo--->", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("AddFragment EvenDemo--->", "onDetach")
    }
}