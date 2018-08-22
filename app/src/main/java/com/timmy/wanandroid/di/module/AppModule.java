package com.timmy.wanandroid.di.module;

import com.timmy.wanandroid.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App providesApplicationContext() {
        return this.application;
    }

}
