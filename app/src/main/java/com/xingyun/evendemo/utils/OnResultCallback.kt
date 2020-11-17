package com.xingyun.evendemo.utils

interface OnResultCallback<T> {
    fun onSuccess(data: T)

    fun onError(errorCode: Int, errorMsg: String)
}