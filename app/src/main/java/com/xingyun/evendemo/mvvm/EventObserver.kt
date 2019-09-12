package com.xingyun.evendemo.mvvm

import androidx.lifecycle.Observer


class EventObserver<T>(private val action: (T) -> Unit) : Observer<Event<T>> {

    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let(action)
    }
}
