package com.timmy.wanandroid.core.activity;

import com.timmy.wanandroid.App;
import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.core.view.IBaseView;
import com.timmy.wanandroid.di.component.ActivityComponent;
import com.timmy.wanandroid.di.component.DaggerActivityComponent;
import com.timmy.wanandroid.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * mvp activity
 */
public abstract class MvpBasicActivity<T extends IBasePresenter> extends BasicActivity implements IBaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    protected abstract void initInject();

}
