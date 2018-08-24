package com.timmy.wanandroid.app;

import android.os.Environment;

import java.io.File;

public interface Constants {

    /**
     * 应用目录
     */
    String PATH_APP = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "WanAndroid";
    /**
     * 数据主目录
     */
    String PATH_DATA = PATH_APP + File.separator + "data";
    /**
     * 缓存主目录
     */
    String PATH_CACHE = PATH_APP + File.separator + "cache";
    /**
     * 网络缓存
     */
    String PATH_CACHE_NET = PATH_CACHE + File.separator + "net";
    /**
     * 图片缓存
     */
    String PATH_IMAGE = PATH_APP + File.separator + "image";
    /**
     * 日志
     */
    String PATH_LOGS = PATH_DATA + File.separator + "logs";
    String FILE_PROVIDER_AUTHORITY = "com.timmy.wanandroid.fileprovider";
}
