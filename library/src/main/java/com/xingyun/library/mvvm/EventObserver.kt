package com.xingyun.library.mvvm

import androidx.lifecycle.Observer


class EventObserver<T>(private val action: (T) -> Unit) : Observer<com.xingyun.library.mvvm.Event<T>> {

    override fun onChanged(event: com.xingyun.library.mvvm.Event<T>?) {
        event?.getContentIfNotHandled()?.let(action)
    }
}
