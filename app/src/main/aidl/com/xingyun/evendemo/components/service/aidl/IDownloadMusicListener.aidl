// IDownloadMusicListener.aidl
package om.xingyun.evendemo.components.service.aidl;

interface IDownloadMusicListener {
   void startDownload(String message);

   void proccess(int proccess);

   void downloadFinish(String message);
}
