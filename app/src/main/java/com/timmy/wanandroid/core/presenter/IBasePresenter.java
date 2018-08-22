package com.timmy.wanandroid.core.presenter;

import com.timmy.wanandroid.core.view.IBaseView;

/**
 * Presenter基类
 */
public interface IBasePresenter<T extends IBaseView> {
    /**
     * mvp与视图关联
     * @param view
     */
    void attachView(T view);

    /**
     * mvp与视图断开连接
     */
    void detachView();
}
