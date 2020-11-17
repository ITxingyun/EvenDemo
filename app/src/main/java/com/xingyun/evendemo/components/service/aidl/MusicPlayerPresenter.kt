package com.xingyun.evendemo.components.service.aidl

import com.xingyun.evendemo.utils.OnResultCallback

class MusicPlayerPresenter(
        private val stub: MusicPlayerContract.IStub,
        private val model: MusicPlayerContract.IModel
) {


    fun downloadMusic(music: Music?) {
        music?.run {
            stub.startDownload(musicName ?: "")
            model.downloadMusic(object : OnResultCallback<Music> {
                override fun onSuccess(data: Music) {
                    stub.downloadFinish(data.musicName ?: "")
                }

                override fun onError(errorCode: Int, errorMsg: String) {
                    stub.downloadFinish("下载失败")
                }
            })
        }

    }


}