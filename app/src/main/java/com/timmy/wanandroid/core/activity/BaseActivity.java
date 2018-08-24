package com.timmy.wanandroid.core.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.timmy.wanandroid.R;
import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.widget.ProgressImageView;

public abstract class BaseActivity<T extends IBasePresenter> extends MvpBasicActivity<T> {


    private static final int STATE_MAIN = 0x00;
    private static final int STATE_LOADING = 0x01;
    private static final int STATE_ERROR = 0x02;

    private ProgressImageView ivLoading;
    private View viewError;
    private View viewLoading;
    private ViewGroup viewMain;
    private ViewGroup mParent;

    private int mErrorResource = R.layout.view_error;

    private int currentState = STATE_MAIN;
    private boolean isErrorViewAdded = false;

    @Override
    protected void initStateUI(Bundle savedInstanceState) {
        viewMain = findViewById(R.id.view_content_root);
        if (viewMain == null) {
            throw new IllegalStateException("The subclass of RootActivity must contain a View named 'view_content_root'.");
        }
        if (!(viewMain.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException("view_main's ParentView should be a ViewGroup.");
        }
        mParent = (ViewGroup) viewMain.getParent();
        View.inflate(mContext, R.layout.view_progress, mParent);
        viewLoading = mParent.findViewById(R.id.view_loading);
        ivLoading = viewLoading.findViewById(R.id.iv_progress);
        viewLoading.setVisibility(View.GONE);
        viewMain.setVisibility(View.VISIBLE);
        initEventAndData(savedInstanceState);
    }

    @Override
    public void stateError() {
        if (currentState == STATE_ERROR)
            return;
        if (!isErrorViewAdded) {
            isErrorViewAdded = true;
            View.inflate(mContext, mErrorResource, mParent);
            viewError = mParent.findViewById(R.id.view_error);
            if (viewError == null) {
                throw new IllegalStateException(
                        "A View should be named 'view_error' in ErrorLayoutResource.");
            }
        }
        hideCurrentView();
        currentState = STATE_ERROR;
        viewError.setVisibility(View.VISIBLE);
    }

    @Override
    public void stateLoading() {
        if (currentState == STATE_LOADING)
            return;
        hideCurrentView();
        currentState = STATE_LOADING;
        viewLoading.setVisibility(View.VISIBLE);
        ivLoading.start();
    }

    @Override
    public void stateMain() {
        if (currentState == STATE_MAIN)
            return;
        hideCurrentView();
        currentState = STATE_MAIN;
        viewMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void stateEmpty() {
        // TODO
    }

    private void hideCurrentView() {
        switch (currentState) {
            case STATE_MAIN:
                viewMain.setVisibility(View.GONE);
                break;
            case STATE_LOADING:
                ivLoading.stop();
                viewLoading.setVisibility(View.GONE);
                break;
            case STATE_ERROR:
                if (viewError != null) {
                    viewError.setVisibility(View.GONE);
                }
                break;
        }
    }

    /**
     * 加载出错时显示的UI
     *
     * @param errorLayoutResource 布局id
     */
    public void setErrorResource(int errorLayoutResource) {
        this.mErrorResource = errorLayoutResource;
    }

    /**
     * 界面入口
     */
    protected abstract void initEventAndData(Bundle savedInstanceState);

}
