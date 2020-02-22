package com.xingyun.evendemo.home

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xingyun.evendemo.common.BaseFragment
import com.xingyun.evendemo.mvvm.Event

class MainActivityViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun showSpinner(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    private val _isToolbarVisibleAction = MutableLiveData<Boolean>().apply { value = false }
    val isToolbarVisible: LiveData<Boolean>
        get() = _isToolbarVisibleAction

    fun hideToolbar(isToolbarVisible: Boolean) {
        _isToolbarVisibleAction.value = isToolbarVisible
    }

    private val _title = MutableLiveData<Int>()
    val title: LiveData<Int>
        get() = _title

    fun updateTitle(title: Int) {
        if (title != _title.value) {
            _title.value = title
        }
    }

    private val _titleString = MutableLiveData<String>()
    val titleString: LiveData<String>
        get() = _titleString

    fun updateTitleString(title: String) {
        if (title != _titleString.value) {
            _titleString.value = title
        }
    }

    private val _navigationIcon: MutableLiveData<Int> = MutableLiveData()
    val navigationIcon: LiveData<Int>
        get() = _navigationIcon

    fun updateNavigationIcon(@DrawableRes navigationIconRes: Int) {
        if (navigationIconRes != _navigationIcon.value) {
            _navigationIcon.value = navigationIconRes
        }
    }

    private val _backToPreviousPageAction = MutableLiveData<Event<Unit>>()
    val backToPreviousPage: LiveData<Event<Unit>>
        get() = _backToPreviousPageAction

    fun backToPreviousPage() {
        _backToPreviousPageAction.value = Event(Unit)
    }

    val addFragment = MutableLiveData<Event<BaseFragment>>()

    fun addFragmentToActivity(fragment: BaseFragment) {
        addFragment.value = Event(fragment)
    }

    val replaceFragment = MutableLiveData<Event<BaseFragment>>()

    fun replaceFragmentToActivity(fragment: BaseFragment) {
        replaceFragment.value = Event(fragment)
    }
}