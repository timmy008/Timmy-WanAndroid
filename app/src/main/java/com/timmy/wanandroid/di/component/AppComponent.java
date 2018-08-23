package com.timmy.wanandroid.di.component;

import com.timmy.wanandroid.App;
import com.timmy.wanandroid.di.module.AppModule;
import com.timmy.wanandroid.di.module.HttpModule;
import com.timmy.wanandroid.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    /**
     * 获取Application
     *
     * @return
     */
    App getContext();

    DataManager getDataManager();
}
