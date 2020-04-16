package com.xingyun.evendemo.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
            .also { viewModel = it }
            .run {
                loginResult.observe(this@LoginFragment, EventObserver{
                    when(it) {
                        TEXT_EMPTY_USER_NAME ->
                            showMessage(getString(R.string.login_user_name_error_tip))
                        TEXT_EMPTY_PASSWORD ->
                            showMessage(getString(R.string.login_user_password_tip))
                        LOGIN_SUCCESS ->
                            showMessage(getString(R.string.login_success))
                    }
                })
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
            .apply { viewModel = this@LoginFragment.viewModel }
            .also { binding = it }
            .root

    companion object {
        const val TEXT_EMPTY_USER_NAME = "text_empty_user_name"
        const val TEXT_EMPTY_PASSWORD = "text_empty_password"
        const val LOGIN_SUCCESS = "login_success"
    }
}