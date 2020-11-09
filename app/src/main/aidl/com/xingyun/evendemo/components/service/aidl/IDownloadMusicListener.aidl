// IDownloadMusicListener.aidl
package om.xingyun.evendemo.components.service.aidl;

        interface IDownloadMusicListener {
   void startDownload();

   void proccess(int proccess);

   void downloadFinish();
}
