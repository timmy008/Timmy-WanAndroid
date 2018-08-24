package com.timmy.wanandroid.contract.main;

import com.timmy.wanandroid.core.presenter.IBasePresenter;
import com.timmy.wanandroid.core.view.IBaseView;

public interface SplashContract {

    interface IView extends IBaseView{
        /**
         * 倒计时剩余多少秒
         * @param second
         */
        void countDown(int second);
        void jumpToMainActivity();
    }

    interface IPresenter extends IBasePresenter<IView>{
        void startCountDown();

        void cancelCountDown();
    }
}
