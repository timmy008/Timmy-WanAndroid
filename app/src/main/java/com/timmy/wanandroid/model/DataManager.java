package com.timmy.wanandroid.model;

import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.model.http.response.HttpResponse;
import com.timmy.wanandroid.model.http.IHttpHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * 数据处理中心
 */
public class DataManager implements IHttpHelper {

    private IHttpHelper mHttpHelper;

    public DataManager(IHttpHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }


    @Override
    public Flowable<HttpResponse<List<BannerItemInfo>>> getBanner() {
        return mHttpHelper.getBanner();
    }
}
