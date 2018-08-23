package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.WelcomeBean;

import io.reactivex.Flowable;

public interface IHttpHelper {


    Flowable<WelcomeBean> fetchWelcomeInfo(String res);
}
