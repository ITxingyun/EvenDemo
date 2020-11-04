package com.xingyun.evendemo.components.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ActivityServiceBinding
import com.xingyun.library.base.BaseActivity

/**
 * 1、Service的简单使用
 * 2、IntentService的使用
 * 3、AIDL的使用
 * 4、Service怎么做单元测试
 */
class ServiceActivity : BaseActivity() {
    private lateinit var binding: ActivityServiceBinding
    private var myBinder: MyService.MyBinder? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("ServiceConnection", "onServiceDisconnected -> name = $name")
            myBinder = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("ServiceConnection", "onServiceConnected -> name = $name")
            if (service is MyService.MyBinder) {
                myBinder = service
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.tvStartService.setOnClickListener {
            startService()
        }

        binding.tvBindService.setOnClickListener {
            bindService()
        }

        binding.tvSendMessageToService.setOnClickListener {
            myBinder?.test()
        }

        binding.tvUnbindService.setOnClickListener {
            unbindService(serviceConnection)
        }

        binding.tvStopSelf.setOnClickListener {
            stopService(Intent(this, MyService::class.java))
        }
    }


    /**
     * bindService的实质是什么？
     * 问题：源码看不到
     */
    private fun bindService() {
        val intent = Intent(this, MyService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    /**
     * startService的实质是什么？
     */
    private fun startService() {
        val intent = Intent(this, MyService::class.java)
        startService(intent)
    }


}