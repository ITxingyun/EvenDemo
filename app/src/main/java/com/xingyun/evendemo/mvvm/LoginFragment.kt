package com.xingyun.evendemo.mvvm

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
import com.xingyun.evendemo.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private var has = false

    override fun getFragmentTag(): String = "LoginFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.userName.observe(this, Observer {
            if (has) {
                Log.e("even", it)
            }
            has = true
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
            .apply { viewModel = this@LoginFragment.viewModel }
            .also { binding = it }
            .root

    override fun initData() {

    }

}