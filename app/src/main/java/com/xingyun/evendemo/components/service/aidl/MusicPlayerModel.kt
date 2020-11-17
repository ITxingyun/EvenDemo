package com.xingyun.evendemo.components.service.aidl

import com.xingyun.evendemo.utils.OnResultCallback

class MusicPlayerModel : MusicPlayerContract.IModel {

    override fun downloadMusic(callback: OnResultCallback<Music>) {
        callback.onSuccess(Music("青花瓷周杰伦", "SQ"))
    }
}