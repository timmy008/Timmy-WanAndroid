package com.timmy.wanandroid.presenter.main;

import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.Log;
import com.timmy.wanandroid.core.presenter.RxPresenter;
import com.timmy.wanandroid.model.DataManager;
import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.model.bean.WelcomeBean;
import com.timmy.wanandroid.model.http.response.HttpResponse;
import com.timmy.wanandroid.model.http.subscriber.CommonSubscriber;
import com.timmy.wanandroid.utils.RxUtil;
import com.timmy.wanandroid.utils.ToastUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

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

        addSubscribe(mDataManager.getBanner()
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new CommonSubscriber<List<BannerItemInfo>>(mView) {
                    @Override
                    public void onNext(List<BannerItemInfo> bannerItemInfos) {
                        ToastUtil.shortShow("" + bannerItemInfos.size());
                    }
                })
        );
        return "";
    }
}
