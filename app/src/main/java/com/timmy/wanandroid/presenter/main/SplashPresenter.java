package com.timmy.wanandroid.presenter.main;

import com.timmy.wanandroid.contract.main.SplashContract;
import com.timmy.wanandroid.core.presenter.RxPresenter;
import com.timmy.wanandroid.utils.RxUtil;

import javax.inject.Inject;

public class SplashPresenter extends RxPresenter<SplashContract.IView> implements SplashContract.IPresenter{

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void startCountDown() {
       addSubscribe(
               RxUtil.countDown(5)
               .subscribe(onNext-> mView.countDown(onNext),
                       onError-> mView.jumpToMainActivity(),
                       ()-> mView.jumpToMainActivity())
       );
    }

    @Override
    public void cancelCountDown() {
        unSubscribe();
    }
}
