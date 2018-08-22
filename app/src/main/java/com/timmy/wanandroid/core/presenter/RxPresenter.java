package com.timmy.wanandroid.core.presenter;

import com.timmy.wanandroid.core.view.IBaseView;

/**
 * rx presenter
 *
 * @param <T>
 */
public class RxPresenter<T extends IBaseView> implements IBasePresenter<T> {

    protected T mView;


    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
