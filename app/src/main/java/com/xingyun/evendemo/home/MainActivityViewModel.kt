package com.xingyun.evendemo.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xingyun.evendemo.base.BaseFragment
import com.xingyun.evendemo.mvvm.Event

class MainActivityViewModel: ViewModel() {

    val addFragment = MutableLiveData<Event<BaseFragment>>()

    fun addFragmentToActivity(fragment: BaseFragment) {
        addFragment.value = Event(fragment)
    }

    val replaceFragment = MutableLiveData<Event<BaseFragment>>()

    fun replaceFragmentToActivity(fragment: BaseFragment) {
        replaceFragment.value = Event(fragment)
    }
}