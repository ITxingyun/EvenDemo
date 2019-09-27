package com.xingyun.evendemo.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xingyun.evendemo.mvvm.LoginFragment.Companion.LOGIN_SUCCESS
import com.xingyun.evendemo.mvvm.LoginFragment.Companion.TEXT_EMPTY_PASSWORD
import com.xingyun.evendemo.mvvm.LoginFragment.Companion.TEXT_EMPTY_USER_NAME
import com.xingyun.evendemo.retrofit.WanAndroidServiceRetrofit
import com.xingyun.evendemo.retrofit.applySchedulers
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val wanAndroidServiceRetrofit = WanAndroidServiceRetrofit()

    val userName = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    private val _loginResult = MutableLiveData<Event<String>>()
    val loginResult
    get() = _loginResult

    fun login() {
        when {
            userName.value.isNullOrEmpty() -> _loginResult.value = Event(TEXT_EMPTY_USER_NAME)
            password.value.isNullOrEmpty() -> _loginResult.value = Event(TEXT_EMPTY_PASSWORD)
            else -> {
                wanAndroidServiceRetrofit.login(UserProfile(userName.value, password.value))
                    .compose(applySchedulers())
                    .subscribe(ObserverWrapper.create {
                        subscribed {
                            compositeDisposable.add(it)
                        }
                        success {
                            _loginResult.value = Event(LOGIN_SUCCESS)
                        }
                    })

            }
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}