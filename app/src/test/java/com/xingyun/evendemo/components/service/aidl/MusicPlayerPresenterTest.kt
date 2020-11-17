package com.xingyun.evendemo.components.service.aidl

import com.xingyun.evendemo.utils.OnResultCallback
import io.mockk.*
import org.junit.Before
import org.junit.Test

class MusicPlayerPresenterTest {
    private val stub: MusicPlayerContract.IStub = mockk(relaxed = true)
    private val model: MusicPlayerContract.IModel = mockk()
    private lateinit var presenter: MusicPlayerPresenter

    @Before
    fun setup() {
        presenter = MusicPlayerPresenter(stub, model)
    }

    @Test
    fun test_downloadMusicWithEmptyMusic() {
        presenter.downloadMusic(null)
        verify { stub wasNot Called }
    }

    @Test
    fun test_downloadMusic() {
        val musicName1 = "青花瓷"
        val musicName2 = "青花瓷-周杰伦"
        val music = Music(musicName1, "SQ")
        val slot = slot<OnResultCallback<Music>>()
        justRun { model.downloadMusic(capture(slot)) }
        presenter.downloadMusic(music)
        slot.captured.onSuccess(Music(musicName2, "SQ"))
        verifyOrder {
            stub.startDownload(musicName1)
            stub.downloadFinish(musicName2)
        }
    }


}