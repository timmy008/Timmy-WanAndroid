package com.timmy.wanandroid.presenter.main;

import com.timmy.wanandroid.contract.main.HomeContract;
import com.timmy.wanandroid.core.presenter.RxPresenter;
import com.timmy.wanandroid.model.DataManager;
import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;
import com.timmy.wanandroid.model.http.response.HttpResponse;
import com.timmy.wanandroid.model.http.subscriber.CommonSubscriber;
import com.timmy.wanandroid.utils.CommonUtils;
import com.timmy.wanandroid.utils.RxUtil;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomePresenter extends RxPresenter<HomeContract.IView> implements HomeContract.IPresenter {

    private static final String KEY_BANNER_DATA = "key_banner_data";
    private static final String KEY_ARTICLE_DATA = "key_article_data";

    private DataManager mDataManager;
    private int index = 0;

    @Inject
    public HomePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void loadData() {
        Observable<HttpResponse<ArticleBean>> articleList = mDataManager.getArticleList(index);
        Observable<HttpResponse<List<BannerItemBean>>> banner = mDataManager.getBanner();
        addSubscribe(
                Observable.zip(articleList, banner, (articleResponse, bannerResponse) -> {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(KEY_ARTICLE_DATA, articleResponse);
                    map.put(KEY_BANNER_DATA, bannerResponse);
                    return map;
                }).compose(RxUtil.rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<HashMap<String, Object>>(mView) {
                            @Override
                            public void onNext(HashMap<String, Object> hashMap) {
                                HttpResponse<List<BannerItemBean>> bannerResp = CommonUtils.cast(hashMap.get(KEY_BANNER_DATA));
                                if (bannerResp != null) {
                                    mView.showBannerData(bannerResp.getData());
                                }
                                HttpResponse<ArticleBean> articleResp = CommonUtils.cast(hashMap.get(KEY_ARTICLE_DATA));
                                if (articleResp!=null){
                                    mView.showArticleData(articleResp.getData());
                                }
                                mView.stateMain();
                            }
                        })

        );
    }

    @Override
    public void getBanner() {
        addSubscribe(mDataManager.getBanner()
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new CommonSubscriber<List<BannerItemBean>>(mView) {
                    @Override
                    public void onNext(List<BannerItemBean> bannerItemBeans) {
                        mView.showBannerData(bannerItemBeans);
                    }
                })
        );
    }

    @Override
    public void getAticleList(int index) {
        addSubscribe(mDataManager.getArticleList(index)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new CommonSubscriber<ArticleBean>(mView) {

                    @Override
                    public void onNext(ArticleBean articleBean) {

                    }
                })
        );
    }
}
