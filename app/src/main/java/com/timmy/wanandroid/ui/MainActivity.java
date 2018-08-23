package com.timmy.wanandroid.ui;

import com.timmy.wanandroid.R;
import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.activity.BaseActivity;
import com.timmy.wanandroid.presenter.main.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView {


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getMy();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


}
