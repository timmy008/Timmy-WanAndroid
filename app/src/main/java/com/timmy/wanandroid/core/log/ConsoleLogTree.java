package com.timmy.wanandroid.core.log;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

/**
 * log控制台打印
 */
public class ConsoleLogTree extends Timber.DebugTree{
    @Override
    protected void log(int priority, String tag, @NotNull String message, Throwable t) {
        super.log(priority, tag, message, t);
    }
}
