package com.timmy.wanandroid.model;

import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;
import com.timmy.wanandroid.model.http.IHttpHelper;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * 数据处理中心
 */
public class DataManager implements IHttpHelper {

    private IHttpHelper mHttpHelper;

    public DataManager(IHttpHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }


    @Override
    public Observable<HttpResponse<List<BannerItemBean>>> getBanner() {
        return mHttpHelper.getBanner();
    }

    @Override
    public Observable<HttpResponse<ArticleBean>> getArticleList(int index) {
        return mHttpHelper.getArticleList(index);
    }


}
