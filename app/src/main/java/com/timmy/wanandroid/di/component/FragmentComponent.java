package com.timmy.wanandroid.di.component;

import android.app.Activity;

import com.timmy.wanandroid.di.module.FragmentModule;
import com.timmy.wanandroid.di.scope.FragmentScope;
import com.timmy.wanandroid.ui.main.fragment.HomeFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();
    void inject(HomeFragment homeFragment);}
