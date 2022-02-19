package com.xingyun.frame.rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xingyun.frame.R
import com.xingyun.frame.databinding.ActivityRxjavaBinding
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RxJavaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRxjavaBinding>(this, R.layout.activity_rxjava)

        binding.tvSubscribe.setOnClickListener {
            subscribe()
        }
    }

    private fun subscribe() {
        Observable.create(ObservableOnSubscribe<String> {
            Log.e("frame", "Observable: ${Thread.currentThread()}")
            it.onNext("1")
            it.onNext("2")
            it.onNext("3")
            it.onError(NullPointerException())
            it.onNext("4")
            it.onNext("5")
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
            override fun onComplete() {
                Log.e("frame", "onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.e("frame", "Observer onSubscribe: ${Thread.currentThread()}")
            }

            override fun onNext(t: String) {
                Log.e("frame", "onNext: $t Thread: ${Thread.currentThread()}")
            }

            override fun onError(e: Throwable) {
                Log.e("frame", "onError")
            }

        })


    }
}