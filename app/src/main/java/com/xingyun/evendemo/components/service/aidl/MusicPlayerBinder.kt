package com.xingyun.evendemo.components.service.aidl

import om.xingyun.evendemo.components.service.aidl.IDownloadMusicListener

/**
 * Activity和Service之间是通过Binder来通信的
 */
class MusicPlayerBinder : IMusicPlayer.Stub(), MusicPlayerContract.IStub {
    private lateinit var presenter: MusicPlayerPresenter
    private var downloadListener: IDownloadMusicListener? = null

    fun onCreate() {
        presenter = MusicPlayerPresenter(this, MusicPlayerModel())
    }

    override fun registerListener(listener: IDownloadMusicListener?) {
        downloadListener = listener
    }

    override fun unregisterListener(listener: IDownloadMusicListener?) {
        downloadListener = null
    }

    override fun downloadMusic(music: Music?) {
        presenter.downloadMusic(music)
    }


    override fun startDownload(message: String) {
        downloadListener?.startDownload("开始下载-> $message")
    }

    override fun process(process: Int) {
        downloadListener?.proccess(process)
    }

    override fun downloadFinish(message: String) {
        downloadListener?.downloadFinish("完成下载-> $message")
    }
}