package com.timmy.wanandroid.contract.main;

import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.core.view.IBaseView;

public interface MainContract {

    interface IView extends IBaseView {

    }

    interface IPresenter extends IBasePresenter<IView> {

    }
}
