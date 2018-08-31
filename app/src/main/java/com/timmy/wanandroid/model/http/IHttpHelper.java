package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface IHttpHelper {



    Observable<HttpResponse<List<BannerItemBean>>> getBanner();

    Observable<HttpResponse<ArticleBean>> getArticleList(int index);
}
