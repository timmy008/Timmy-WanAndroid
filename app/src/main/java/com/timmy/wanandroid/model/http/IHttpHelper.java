package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.HttpResponse;

import io.reactivex.Flowable;

public interface IHttpHelper {



    Flowable<HttpResponse> getBanner();
}
