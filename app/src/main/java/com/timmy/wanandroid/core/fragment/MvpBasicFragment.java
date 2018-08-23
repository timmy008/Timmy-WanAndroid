package com.timmy.wanandroid.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.timmy.wanandroid.App;
import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.core.view.IBaseView;
import com.timmy.wanandroid.di.component.DaggerFragmentComponent;
import com.timmy.wanandroid.di.component.FragmentComponent;
import com.timmy.wanandroid.di.module.FragmentModule;

import javax.inject.Inject;

public abstract class MvpBasicFragment<T extends IBasePresenter> extends BasicFragment implements IBaseView {
    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        // SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }


    protected abstract void initInject();

}
