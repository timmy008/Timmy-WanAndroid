package com.timmy.wanandroid.core.log;


import android.support.annotation.Nullable;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.timmy.wanandroid.BuildConfig;

import timber.log.Timber;

/**
 * 日志处理工具
 */
public class TLog {
    private TLog() {

    }

    public static void init() {

        Timber.plant(new ConsoleLogTree(),
                new FileLogTree());
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
        FormatStrategy formatStrategy = CsvFormatStrategy.newBuilder()
                .tag("timmy")
                .build();

        Logger.addLogAdapter(new DiskLogAdapter(formatStrategy));
    }

    public static void d(Object object) {
        Logger.d(object);
    }

    public static void d(String msg, Object... object) {
        Logger.d(msg, object);
    }

    public static void e(String msg, Object... object) {
        Logger.e(msg, object);
    }

    public static void e(Throwable throwable, String msg, Object object) {
        Logger.e(throwable, msg, object);
    }

    public static void i(String msg, Object... object) {
        Logger.i(msg, object);
    }

    public static void json(String json) {
        Logger.json(json);
    }


    public static void v(String msg, Object... object) {
        Logger.v(msg, object);
    }

    public static void w(String msg, Object... object) {
        Logger.w(msg, object);
    }

    public static void wtf(String msg, Object... object) {
        Logger.wtf(msg, object);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }


}
