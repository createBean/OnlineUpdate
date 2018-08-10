package com.yu.onlineupdate;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x01;
    private String downloadUrl = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";
    private String title = "测试应用.apk";
    private String desc = "下载完成后，点击安装";
    private DownloadManagerUtil downloadManagerUtil;
    long downloadId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadManagerUtil = new DownloadManagerUtil(this);
    }

    public void onPermissionAction(View view) {
        autoObtainStoragePermission();
    }

    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            Toast.makeText(this, "已经有权限了", Toast.LENGTH_LONG).show();
        }
    }

    public void onUpdateAction(View view) {
        if (downloadId !=0){
            downloadManagerUtil.clearCurrentTask(downloadId);
        }
        downloadId = downloadManagerUtil.download(downloadUrl,title,desc);
    }
}
