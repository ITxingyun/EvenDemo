package com.xingyun.evendemo.components.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.components.service.aidl.IMusicPlayer
import com.xingyun.evendemo.components.service.aidl.Music
import com.xingyun.evendemo.components.service.aidl.MusicManagerService
import com.xingyun.evendemo.databinding.ActivityServiceBinding
import com.xingyun.evendemo.utils.EvenLog
import com.xingyun.library.base.BaseActivity
import om.xingyun.evendemo.components.service.aidl.IDownloadMusicListener

/**
 * 1、Service的简单使用
 * 2、IntentService的使用
 * 3、AIDL的使用，以及AIDL的本质是什么
 * 4、Service怎么做单元测试
 */
class ServiceActivity : BaseActivity() {
    private lateinit var binding: ActivityServiceBinding

    //region Service的简单使用
    private var myBinder: MyService.MyBinder? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            EvenLog.d("ServiceConnection", "name = $name")
            myBinder = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            EvenLog.d("ServiceConnection", "name = $name")
            if (service is MyService.MyBinder) {
                myBinder = service
            }
        }

    }
    //endregion

    //region AIDL的使用
    private var musicPlayer: IMusicPlayer? = null

    private val downloadMusicListener = object : IDownloadMusicListener.Stub() {
        override fun startDownload(message: String) {
            EvenLog.d(TAG, message)
        }

        override fun downloadFinish(message: String) {
            EvenLog.d(TAG, message)
        }

        override fun proccess(proccess: Int) {
            EvenLog.d(TAG, "客户端：下载进度 $proccess%")
        }

    }

    private val downLoadMusicConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            musicPlayer?.unregisterListener(downloadMusicListener)
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            musicPlayer = IMusicPlayer.Stub.asInterface(service)
            musicPlayer?.registerListener(downloadMusicListener)
        }

    }
    //endregion

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

        binding.tvStartIntentService.setOnClickListener {
            startIntentService()
        }

        binding.tvDownloadMusic.setOnClickListener {
            musicPlayer?.downloadMusic(Music("青花瓷", "最好的"))
        }

        bindMusicManagerService()
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

    private fun startIntentService() {
        val intent = Intent(this, MyIntentService::class.java)
        startService(intent)
    }

    /**
     * AIDL demo
     */
    private fun bindMusicManagerService() {
        val intent = Intent(this, MusicManagerService::class.java)
        bindService(intent, downLoadMusicConnection, Context.BIND_AUTO_CREATE)
    }


    companion object {
        private const val TAG = "ServiceActivity"
    }

}