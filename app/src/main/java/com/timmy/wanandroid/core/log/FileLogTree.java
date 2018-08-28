package com.timmy.wanandroid.core.log;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

/**
 * log保存文件
 */
public class FileLogTree extends Timber.DebugTree {
    @Override
    protected void log(int priority, String tag, @NotNull String message, Throwable t) {
    }
}
