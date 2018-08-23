package com.timmy.wanandroid.model.http.api;

import com.timmy.wanandroid.model.bean.HttpResponse;
import com.timmy.wanandroid.model.bean.WelcomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apis {

    String HOST = "http://www.wanandroid.com/";



    @GET("banner/json")
    Flowable<HttpResponse> getBanner();

}
