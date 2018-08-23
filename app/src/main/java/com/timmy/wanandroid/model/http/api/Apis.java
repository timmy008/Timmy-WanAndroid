package com.timmy.wanandroid.model.http.api;

import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Apis {

    String HOST = "http://www.wanandroid.com/";



    @GET("banner/json")
    Flowable<HttpResponse<List<BannerItemInfo>>> getBanner();

}
