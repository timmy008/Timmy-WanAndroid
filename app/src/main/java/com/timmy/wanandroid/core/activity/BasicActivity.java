package com.timmy.wanandroid.core.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.timmy.wanandroid.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BasicActivity extends SupportActivity {

    private Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    protected void onViewCreated() {

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }

    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
