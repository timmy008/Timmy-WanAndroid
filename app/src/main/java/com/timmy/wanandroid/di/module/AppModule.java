package com.timmy.wanandroid.di.module;

import com.timmy.wanandroid.App;
import com.timmy.wanandroid.model.DataManager;
import com.timmy.wanandroid.model.http.IHttpHelper;
import com.timmy.wanandroid.model.http.RetrofitHelper;

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
    App provideApplicationContext() {
        return this.application;
    }


    @Provides
    @Singleton
    IHttpHelper provideHttpHelper(RetrofitHelper helper) {
        return helper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(IHttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}
