package com.example.frame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.frame.eventbus.EventBusActivity
import com.example.frame.eventbus.MessageEvent
import com.example.frame.glide.GlideActivity
import com.example.frame.greendao.GreenDaoActivity
import com.example.frame.leakcanary.LeakCanaryActivity
import com.example.frame.okhttp.OkHttpActivity
import com.example.frame.rxjava.RxJavaActivity
import com.example.frame.retrofit.RetrofitActivity
import com.xingyun.library.utils.start
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_event_bus.setOnClickListener {
            Thread(Runnable {
                EventBus.getDefault().postSticky(MessageEvent("xingyun"))
            }).start()
            start<EventBusActivity>()
        }

        tv_rx_java.setOnClickListener {
            start<RxJavaActivity>()
        }

        tv_glide.setOnClickListener {
            start<GlideActivity>()
        }

        tv_leak_canary.setOnClickListener {
            start<LeakCanaryActivity>()
        }

        tv_green_dao.setOnClickListener {
            start<GreenDaoActivity>()
        }

        tv_ok_http.setOnClickListener {
            start<OkHttpActivity>()
        }

        tv_retrofit.setOnClickListener {
            start<RetrofitActivity>()
        }

    }




}
