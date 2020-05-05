package com.xingyun.library.mvvm

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content

    fun copy() = Event(content)

    fun handleEvent() {
        hasBeenHandled = true
    }
}