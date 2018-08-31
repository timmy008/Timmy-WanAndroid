package com.timmy.wanandroid.model.http.api;

import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Apis {

    String HOST = "http://www.wanandroid.com/";


    /**
     * 首页banner
     * @return
     */
    @GET("banner/json")
    Observable<HttpResponse<List<BannerItemBean>>> getBanner();

    /**
     * 首页文章列表
     * @param index
     * @return
     */
    @GET("article/list/{index}/json")
    Observable<HttpResponse<ArticleBean>> getArticleList(@Path("index") int index);

}
