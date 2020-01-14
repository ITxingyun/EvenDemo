package com.xingyun.evendemo.mvvm

import com.xingyun.evendemo.http.retrofit.RetrofitException
import com.xingyun.evendemo.rxjava.XYObserver
import io.reactivex.disposables.Disposable

typealias Success<T> = (T) -> Unit
typealias Subscribed = (Disposable) -> Unit
typealias NetWorkError = (RetrofitException) -> Unit
typealias FinalAction = () -> Unit
typealias Complete = () -> Unit
typealias LocalError = (Throwable) -> Unit

class ObserverWrapper<T> private constructor(
        private val success: Success<T>,
        private val subscribed: Subscribed,
        private val netWorkError: NetWorkError,
        private val localError: LocalError,
        private val finalAction: FinalAction,
        private var complete: Complete
) : XYObserver<T>() {

    override fun onSubscribe(disposable: Disposable) {
        super.onSubscribe(disposable)
        subscribed(disposable)
    }

    override fun onSuccess(t: T) {
        success(t)
    }

    override fun onFinal() {
        finalAction()
    }

    override fun onError(retrofitException: RetrofitException) {
        netWorkError(retrofitException)
    }

    override fun onError(throwable: Throwable) {
        if (isRetrofitException(throwable)) {
            super.onError(throwable)
        } else {
            onLoadDataError(throwable)
            finalAction()
        }
    }

    override fun onComplete() {
        complete()
    }

    private fun isRetrofitException(throwable: Throwable): Boolean = throwable is RetrofitException

    private fun onLoadDataError(throwable: Throwable) {
        localError(throwable)
    }

    companion object {
        fun <T> create(block: ObserverBuilder<T>.() -> Unit) = ObserverBuilder<T>().apply(block).create()
    }

    class ObserverBuilder<T>(
            private var success: Success<T> = {},
            private var subscribed: Subscribed = {},
            private var netWorkError: NetWorkError = {},
            private var localError: LocalError = {},
            private var finalAction: FinalAction = {},
            private var complete: Complete = {}
    ) {

        fun success(success: Success<T>) = apply { this.success = success }
        fun subscribed(subscribed: Subscribed) = apply { this.subscribed = subscribed }
        fun netWorkError(netWorkError: NetWorkError) = apply { this.netWorkError = netWorkError }
        fun localError(localError: LocalError) = apply { this.localError = localError }
        fun onFinal(onFinal: FinalAction) = apply { this.finalAction = onFinal }
        fun onComplete(onComplete: Complete) = apply { this.complete = onComplete }

        fun create() = ObserverWrapper(success, subscribed, netWorkError, localError, finalAction, complete)
    }
}


