package com.timmy.wanandroid.core.view;

/**
 * View基类
 */
public interface IBaseView {

     void showErrorMsg(String msg);

    // void useNightMode(boolean isNight);

    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
