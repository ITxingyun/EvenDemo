package com.xingyun.frame

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.xingyun.frame.databinding.ActivityMainBinding
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
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.tvEventBus.setOnClickListener {
            Thread {
                EventBus.getDefault().postSticky(MessageEvent("xingyun"))
            }.start()
            start<EventBusActivity>()
        }

        binding.tvRxJava.setOnClickListener {
            start<RxJavaActivity>()
        }

        binding.tvGlide.setOnClickListener {
            start<GlideActivity>()
        }

        binding.tvLeakCanary.setOnClickListener {
            start<LeakCanaryActivity>()
        }

        binding.tvGreenDao.setOnClickListener {
            start<GreenDaoActivity>()
        }

        binding.tvOkHttp.setOnClickListener {
            start<OkHttpActivity>()
        }

        binding.tvRetrofit.setOnClickListener {
            ARouter.getInstance().build("/test/activity").navigation();
        }

        binding.tvHilt.setOnClickListener {
            start<HiltUnSupportActivity>()
        }

    }




}
