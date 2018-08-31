package com.timmy.wanandroid.model.http;

import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;
import com.timmy.wanandroid.model.http.api.Apis;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class RetrofitHelper implements IHttpHelper {
    private Apis mApi;

    @Inject
    public RetrofitHelper(Apis apis) {
        this.mApi = apis;
    }


    @Override
    public Observable<HttpResponse<List<BannerItemBean>>> getBanner() {
        return mApi.getBanner();
    }

    @Override
    public Observable<HttpResponse<ArticleBean>> getArticleList(int index) {
        return mApi.getArticleList(index);
    }
}
