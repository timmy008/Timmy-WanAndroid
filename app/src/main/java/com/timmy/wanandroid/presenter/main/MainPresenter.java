package com.timmy.wanandroid.presenter.main;

import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.presenter.RxPresenter;

import javax.inject.Inject;

public class MainPresenter extends RxPresenter<MainContract.IView> implements MainContract.IPresenter {

    @Inject
    public MainPresenter() {
    }
}
