package com.timmy.wanandroid.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;

import com.timmy.wanandroid.R;
import com.timmy.wanandroid.contract.main.SplashContract;
import com.timmy.wanandroid.core.activity.BaseActivity;
import com.timmy.wanandroid.presenter.main.SplashPresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.IView {

    @BindView(R.id.tv_jump_main_activity)
    AppCompatTextView mTvjumpMainActivity;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        mPresenter.applyPermission(this);
    }

    @Override
    public void countDown(int second) {
        mTvjumpMainActivity.setText(getString(R.string.splash_count_down, second));
    }


    @Override
    public void jumpToMainActivity() {
        jumpMainActivity();
    }


    @OnClick(R.id.tv_jump_main_activity)
    public void onViewClicked() {
        jumpMainActivity();
    }

    private void jumpMainActivity() {
        mPresenter.cancelCountDown();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
