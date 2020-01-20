package com.xingyun.evendemo.opensoruce.http.retrofit

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> applySchedulers() = ObservableTransformer<T, T> { upstream ->
    upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

