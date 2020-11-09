// IMusicPlayer.aidl
package com.xingyun.evendemo.components.service.aidl;

import com.xingyun.evendemo.components.service.aidl.Music;
import com.xingyun.evendemo.components.service.aidl.IDownloadMusicListener;

interface IMusicPlayer {
    void downloadMusic(in Music novel);

    void registerListener(IDownloadMusicListener listener);

    void unregisterListener(IDownloadMusicListener listener);
}
