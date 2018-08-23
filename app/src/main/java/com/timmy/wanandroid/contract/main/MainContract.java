package com.timmy.wanandroid.contract.main;

import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.core.view.IBaseView;
import com.timmy.wanandroid.model.bean.BannerItemInfo;

import java.util.List;

public interface MainContract {

    interface IView extends IBaseView {

        void showBanner(List<BannerItemInfo> bannerItemInfos);
    }

    interface IPresenter extends IBasePresenter<IView> {
        void getBanner();
    }
}
