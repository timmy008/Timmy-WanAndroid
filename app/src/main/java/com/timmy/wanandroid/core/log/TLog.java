package com.timmy.wanandroid.core.log;


import timber.log.Timber;

/**
 * 日志处理工具
 */
public class TLog {


    private static boolean IS_SHOW_LOG = true;

    private TLog() {

    }

    public static void init(boolean isShowLog) {
        IS_SHOW_LOG = isShowLog;
        Timber.plant(new ConsoleLogTree(),
                new FileLogTree());
    }

    public static void d(String message) {
        Timber.d(message);
    }

    public static void v(String message) {
        Timber.d(message);
    }

    public static void e(String message) {
        Timber.e(message);
    }

    public static void e(Throwable throwable, String message) {
        Timber.e(throwable, message);
    }

    public static void e(Throwable t) {
        Timber.e(t);
    }


}
