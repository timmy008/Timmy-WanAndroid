package com.timmy.wanandroid.presenter.main;

import android.Manifest;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.timmy.wanandroid.contract.main.SplashContract;
import com.timmy.wanandroid.core.activity.BasicActivity;
import com.timmy.wanandroid.core.presenter.RxPresenter;
import com.timmy.wanandroid.ui.main.activity.SplashActivity;
import com.timmy.wanandroid.utils.RxUtil;

import javax.inject.Inject;

public class SplashPresenter extends RxPresenter<SplashContract.IView> implements SplashContract.IPresenter {


    @Inject
    public SplashPresenter() {

    }

    @Override
    public void applyPermission(SplashActivity activity) {
        addSubscribe(new RxPermissions(activity)
                .request(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        startCountDown();
                    } else {
                        startCountDown();
                    }
                }));
    }

    @Override
    public void startCountDown() {
        addSubscribe(
                RxUtil.countDown(2)
                        .subscribe(onNext -> mView.countDown(onNext),
                                onError -> mView.jumpToMainActivity(),
                                () -> mView.jumpToMainActivity())
        );
    }

    @Override
    public void cancelCountDown() {
        unSubscribe();
    }


}
