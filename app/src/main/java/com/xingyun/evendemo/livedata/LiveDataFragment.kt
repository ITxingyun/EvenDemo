package com.xingyun.evendemo.livedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.BaseFragment
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.FragmentLiveDataBinding

class LiveDataFragment : BaseFragment() {
    private lateinit var binding: FragmentLiveDataBinding
    private lateinit var viewModel: LoginViewModel

    override fun getFragmentTag(): String = "LiveDataFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.userName.observe(this, Observer {
            Log.e("111", it)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentLiveDataBinding>(inflater, R.layout.fragment_live_data, container, false)
                .also { binding = it }
                .root

    override fun initData() {

    }

}