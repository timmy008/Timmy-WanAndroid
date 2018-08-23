package com.timmy.wanandroid.app;

import android.os.Environment;

import com.timmy.wanandroid.App;

import java.io.File;

public interface Constants {

    String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    String PATH_CACHE = PATH_DATA + "/NetCache";
    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";
    String FILE_PROVIDER_AUTHORITY = "com.codeest.geeknews.fileprovider";
}
