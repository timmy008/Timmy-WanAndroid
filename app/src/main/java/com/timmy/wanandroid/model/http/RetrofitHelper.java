package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.model.http.response.HttpResponse;
import com.timmy.wanandroid.model.http.api.Apis;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RetrofitHelper implements IHttpHelper {
    private Apis mApi;

    @Inject
    public RetrofitHelper(Apis apis) {
        this.mApi = apis;
    }


    @Override
    public Flowable<HttpResponse<List<BannerItemInfo>>> getBanner() {
        return mApi.getBanner();
    }
}
