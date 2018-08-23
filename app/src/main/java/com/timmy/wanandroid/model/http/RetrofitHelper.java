package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.WelcomeBean;
import com.timmy.wanandroid.model.http.api.Apis;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RetrofitHelper implements IHttpHelper {
    private Apis mApi;

    @Inject
    public RetrofitHelper(Apis apis) {
        this.mApi = apis;
    }




    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mApi.getWelcomeInfo(res);
    }
}
