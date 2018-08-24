package com.timmy.wanandroid.di.component;

import android.app.Activity;

import com.timmy.wanandroid.di.module.ActivityModule;
import com.timmy.wanandroid.di.scope.ActivityScope;
import com.timmy.wanandroid.ui.main.activity.MainActivity;
import com.timmy.wanandroid.ui.main.activity.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);
    void inject(SplashActivity mainActivity);



}
