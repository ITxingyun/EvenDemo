package com.xingyun.evendemo.rxjava

import com.xingyun.evendemo.http.retrofit.RetrofitException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class XYObserver<T> : Observer<T> {
    private lateinit var disposable: Disposable

    override fun onComplete() = Unit

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        onSuccess(t)
        onFinal()
    }

    override fun onError(throwable: Throwable) {
        if (throwable is RetrofitException) {
            onError(throwable)
        }
        onFinal()
    }

    abstract fun onSuccess(t: T)

    protected open fun onFinal() = Unit

    protected open fun onError(retrofitException: RetrofitException) = Unit

    protected open fun cancel() = disposable.dispose()
}