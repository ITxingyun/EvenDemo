package com.xingyun.evendemo.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xingyun.evendemo.mvvm.LoginFragment.Companion.LOGIN_SUCCESS
import com.xingyun.evendemo.mvvm.LoginFragment.Companion.TEXT_EMPTY_PASSWORD
import com.xingyun.evendemo.mvvm.LoginFragment.Companion.TEXT_EMPTY_USER_NAME

class LoginViewModel : ViewModel() {
    val userName = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    private val _loginResult = MutableLiveData<Event<String>>()
    val loginResult
    get() = _loginResult

    fun login() {
        when {
            userName.value.isNullOrEmpty() -> _loginResult.value = Event(TEXT_EMPTY_USER_NAME)
            password.value.isNullOrEmpty() -> _loginResult.value = Event(TEXT_EMPTY_PASSWORD)
            else -> _loginResult.value = Event(LOGIN_SUCCESS)
        }
    }

}