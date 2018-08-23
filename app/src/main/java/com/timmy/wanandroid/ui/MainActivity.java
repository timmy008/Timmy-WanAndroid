package com.timmy.wanandroid.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.ContentFrameLayout;

import com.timmy.wanandroid.R;
import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.activity.BaseActivity;
import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.presenter.main.MainPresenter;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView {


    @BindView(R.id.cfl_group)
    ContentFrameLayout mCflGroup;
    @BindView(R.id.bnv_main)
    BottomNavigationView mBnvMain;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        //mPresenter.getBanner();
        //stateLoading();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    public void showBanner(List<BannerItemInfo> bannerItemInfos) {
        stateMain();
    }


}
