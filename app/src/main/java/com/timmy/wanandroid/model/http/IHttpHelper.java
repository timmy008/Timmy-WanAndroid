package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface IHttpHelper {



    Flowable<HttpResponse<List<BannerItemInfo>>> getBanner();
}
