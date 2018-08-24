package com.timmy.wanandroid.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;

import com.timmy.wanandroid.R;
import com.timmy.wanandroid.core.activity.BasicActivity;

import butterknife.OnClick;

public class SplashActivity extends BasicActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initStateUI(Bundle savedInstanceState) {
    }


    @OnClick(R.id.btn_go_home)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
