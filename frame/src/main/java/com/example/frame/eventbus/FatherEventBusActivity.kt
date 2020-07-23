package com.example.frame.eventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.frame.R
import kotlinx.android.synthetic.main.activity_event_bus.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

open class FatherEventBusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)
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
        text.text = event.message
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent1(event: MessageEvent) {
        text.text = event.message
    }


}