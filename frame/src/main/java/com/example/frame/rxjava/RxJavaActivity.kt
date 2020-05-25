package com.example.frame.rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.frame.R
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rxjava.*
import java.lang.NullPointerException

class RxJavaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)

        tvSubscribe.setOnClickListener {
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