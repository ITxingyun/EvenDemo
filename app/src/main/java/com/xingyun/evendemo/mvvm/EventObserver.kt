package com.xingyun.evendemo.mvvm

import androidx.lifecycle.Observer


class EventObserver<T>(private val action: (T) -> Unit) : Observer<com.xingyun.evendemo.mvvm.Event<T>> {

    override fun onChanged(event: com.xingyun.evendemo.mvvm.Event<T>?) {
        event?.getContentIfNotHandled()?.let(action)
    }
}
