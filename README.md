# OnlineUpdate
Android system self update DownloadManager usage 

#### In Android development, there is often a need to download data from the server, especially when updating Apps online. The basic idea is to compare the local App version number with the server version number, if the server version is newer, then prompt and download Apk for final installation. There are many requirements for this solution, and the third party network framework basically has this function. 

#### Android's own DownloadManager is a good tool for downloading files. This class appeared after API level 9, it has helped us deal with the download failure, re-download and other functions, the entire download process to the system is responsible for, do not need us to deal with too much, very nice. The key is to use it is also very simple, very cool, slightly encapsulated can be a few words to complete the download.
Here is a simple case to download a Apk file from the server and install it. 

The load manager is a system service that handles long-running HTTP downloads. Applications that request downloads through this API should register a broadcast receiver for ACTION_NOTIFICATION_CLICKED so that the user clicks on the running download in the notification or handles it correctly from the download UI. 

An instance of this class must use Context. getSystemService (Class) with parameters DownloadManager. class or Context. getSystemService (String) and Context. DOWNLOAD_SERVICE. 

Note: you need to add the following two permissions when using. 

A. network access authority <uses-permission android:name= "android.permission.INTERNET" / > 

B. External storage write permissions < uses-permission and roid: name = "android.permission.WRITE_EXTERNAL_STORAGE" />. 

The main steps of this routine are:
1. Add permissions and configure broadcast receivers (for receiving system broadcasts issued after clicks and downloads are completed) 
2. the radio receiver mainly realizes the response of the click event and the download completion event; that is, the click jump to the Download View page is not completed, and the installation application is automatically invoked after completion. 
3. Call update operation in Activity 
4. Download Tool Class Download Manager Util, which mainly completes the parameter settings of Download Manager and starts the download task
