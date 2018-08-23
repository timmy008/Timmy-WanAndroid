package com.timmy.wanandroid.presenter.main;

import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.Log;
import com.timmy.wanandroid.core.presenter.RxPresenter;
import com.timmy.wanandroid.model.DataManager;
import com.timmy.wanandroid.model.bean.WelcomeBean;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends RxPresenter<MainContract.IView> implements MainContract.IPresenter {

    private static final String RES = "1080*1776";
    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    @Override
    public String getMy() {

        addSubscribe(mDataManager.fetchWelcomeInfo(RES)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext -> {
                    String text = onNext.getText();

                }, onError -> {
                    Log.e(onError, "", "");
                }));
        return "";
    }
}
