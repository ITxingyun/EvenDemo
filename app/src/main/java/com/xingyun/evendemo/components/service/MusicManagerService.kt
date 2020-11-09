package com.xingyun.evendemo.components.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.xingyun.evendemo.components.service.aidl.IMusicPlayer
import com.xingyun.evendemo.components.service.aidl.Music
import com.xingyun.evendemo.utils.EvenLog
import om.xingyun.evendemo.components.service.aidl.IDownloadMusicListener

class MusicManagerService : Service() {
    private var downloadListener: IDownloadMusicListener? = null

    private val binder = object : IMusicPlayer.Stub() {

        override fun registerListener(listener: IDownloadMusicListener?) {
            downloadListener = listener
        }

        override fun downloadMusic(novel: Music?) {
            novel?.run {
                downloadListener?.startDownload()
                for (i in 0..100) {
                    downloadListener?.proccess(i)
                    Thread.sleep(50)
                }
                downloadListener?.downloadFinish()
            }
        }

        override fun unregisterListener(listener: IDownloadMusicListener?) {
            downloadListener = null
        }
    }


    override fun onBind(intent: Intent?): IBinder? = binder

    override fun onCreate() {
        super.onCreate()
        EvenLog.d(TAG, "onCreate")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        EvenLog.d(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

    companion object {
        private const val TAG = "MusicManagerService"
    }

}