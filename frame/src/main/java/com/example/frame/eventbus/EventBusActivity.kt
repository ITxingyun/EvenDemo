package com.example.frame.eventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.frame.R
import kotlinx.android.synthetic.main.activity_event_bus.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusActivity : FatherEventBusActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    override fun onMessageEvent(event: MessageEvent) {
        text.text = event.message
    }


}