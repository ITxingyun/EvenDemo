package com.xingyun.evendemo.window

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WindowViewModel: ViewModel() {

    val window = MutableLiveData<Unit>()

    fun newWindow() {
        window.value = Unit
    }

}