package com.xingyun.evendemo.components.broadcast

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ActivityBroadcastBinding
import com.xingyun.library.base.BaseActivity

/**
 * 1、发送广播的三种方式：https://developer.android.com/guide/components/broadcasts?hl=zh-cn#sending-broadcasts
 * 2、接收广播的两种方法：https://developer.android.com/guide/components/broadcasts?hl=zh-cn#receiving-broadcasts
 * 2、怎么接受系统的广播
 * 3、
 */
class BroadcastReceiverActivity : BaseActivity() {
    private lateinit var binding: ActivityBroadcastBinding

    private val broadcastReceiver02 = MyBroadcastReceiver02()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_broadcast)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        //方式一：发送有序广播
        binding.tvSendOrderedBroadcast.setOnClickListener {
            sendOrderedBroadcast(Intent().also { intent ->
                intent.action = MyBroadcastReceiver02.ACTION_TEST_01
                intent.putExtra("data", "有序广播")
                sendBroadcast(intent)
            }, Manifest.permission.SEND_SMS)
        }

        //方式二：发送无序广播
        binding.tvSendBroadcast.setOnClickListener {
            sendBroadcast(Intent().also { intent ->
                intent.action = MyBroadcastReceiver02.ACTION_TEST_01
                intent.putExtra("data", "无序广播")
                sendBroadcast(intent)
            }, Manifest.permission.SEND_SMS)
        }

        //方式三：发送本地广播
        binding.tvSendLocalBroadcast.setOnClickListener {

            LocalBroadcastManager.getInstance(baseContext).sendBroadcast(Intent().also { intent ->
                intent.action = MyBroadcastReceiver02.ACTION_TEST_01
                intent.putExtra("data", "无序广播")
                sendBroadcast(intent)
            })
        }

        registryBroadcastReceiver02()
    }

    private fun registryBroadcastReceiver02() {
        registerReceiver(broadcastReceiver02, MyBroadcastReceiver02.getIntentFilter(), Manifest.permission.SEND_SMS, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver02)
    }

}