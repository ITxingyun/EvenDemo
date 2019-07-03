package com.xingyun.evendemo.mvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val userName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
            .apply { value = "123" }
    }

    val password: LiveData<String> = MutableLiveData()



    fun login() {
        userName.value = "123"
    }

}