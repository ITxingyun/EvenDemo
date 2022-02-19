package com.xingyun.frame.eventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xingyun.frame.R
import com.xingyun.frame.databinding.ActivityEventBusBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

open class FatherEventBusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityEventBusBinding>(this, R.layout.activity_event_bus)
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    open fun onMessageEvent(event: MessageEvent) {
        binding.text.text = event.message
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent1(event: MessageEvent) {
        binding.text.text = event.message
    }


}