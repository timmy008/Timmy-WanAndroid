package com.timmy.wanandroid.presenter.main;

import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.presenter.RxPresenter;
import com.timmy.wanandroid.model.DataManager;
import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.http.subscriber.CommonSubscriber;
import com.timmy.wanandroid.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends RxPresenter<MainContract.IView> implements MainContract.IPresenter {

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    @Override
    public void getBanner() {
//        addSubscribe(mDataManager.getBanner()
//                .compose(RxUtil.rxSchedulerHelper())
//                .compose(RxUtil.handleResult())
//                .subscribeWith(new CommonSubscriber<List<BannerItemBean>>(mView) {
//                    @Override
//                    public void onNext(List<BannerItemBean> bannerItemBeans) {
//                        mView.showBanner(bannerItemBeans);
//                    }
//                })
//        );
    }
}
