package com.xingyun.frame.eventbus

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.xingyun.frame.R
import com.xingyun.frame.databinding.ActivityEventBusBinding
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusActivity : FatherEventBusActivity() {
    private lateinit var binding: ActivityEventBusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_bus)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    override fun onMessageEvent(event: MessageEvent) {
        binding.text.text = event.message
    }


}