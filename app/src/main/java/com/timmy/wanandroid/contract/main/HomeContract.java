package com.timmy.wanandroid.contract.main;

import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.core.view.IBaseView;
import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;

import java.util.List;

public interface HomeContract {

    interface IView extends IBaseView {
        void showBannerData(List<BannerItemBean> bannerData);

        void showArticleData(ArticleBean articleData);
    }


    interface IPresenter extends IBasePresenter<HomeContract.IView> {
        /**
         * 初始化首页数据
         */
        void loadData();

        void getBanner();

        void getAticleList(int index);


    }
}
