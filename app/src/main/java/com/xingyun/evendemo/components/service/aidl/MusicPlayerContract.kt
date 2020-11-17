package com.xingyun.evendemo.components.service.aidl

import com.xingyun.evendemo.utils.OnResultCallback

interface MusicPlayerContract {
    interface IStub {
        fun startDownload(message: String)

        fun process(process: Int)

        fun downloadFinish(message: String)
    }


    interface IModel {
        fun downloadMusic(callback: OnResultCallback<Music>)
    }

}