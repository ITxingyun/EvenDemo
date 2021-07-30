package com.xingyun.frame

import android.os.Bundle
import com.xingyun.frame.eventbus.EventBusActivity
import com.xingyun.frame.eventbus.MessageEvent
import com.xingyun.frame.glide.GlideActivity
import com.xingyun.frame.greendao.GreenDaoActivity
import com.xingyun.frame.hilt.*
import com.xingyun.frame.leakcanary.LeakCanaryActivity
import com.xingyun.frame.okhttp.OkHttpActivity
import com.xingyun.frame.retrofit.RetrofitActivity
import com.xingyun.frame.rxjava.RxJavaActivity
import com.xingyun.library.utils.start
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var user: User

    @Inject
    lateinit var userProfile: UserProfile

    @Inject
    lateinit var userProfile2: UserProfile2

    @Inject
    lateinit var userProfile3: UserProfile3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_event_bus.setOnClickListener {
            Thread {
                EventBus.getDefault().postSticky(MessageEvent("xingyun"))
            }.start()
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

        tv_hilt.setOnClickListener {
            start<HiltUnSupportActivity>()
        }

    }




}
