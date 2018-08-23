package com.timmy.wanandroid.model;

import com.timmy.wanandroid.model.bean.WelcomeBean;
import com.timmy.wanandroid.model.http.IHttpHelper;

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
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mHttpHelper.fetchWelcomeInfo(res);
    }
}
