package com.timmy.wanandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.timmy.wanandroid.core.log.TLog;
import com.timmy.wanandroid.di.component.AppComponent;
import com.timmy.wanandroid.di.component.DaggerAppComponent;
import com.timmy.wanandroid.di.module.AppModule;
import com.timmy.wanandroid.di.module.HttpModule;

import java.util.HashSet;
import java.util.Set;

public class App extends Application {

    private static App instance;
    private RefWatcher mRefWatcher;
    private static AppComponent appComponent;
    private Set<Activity> mActivitysSet;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;


    public static synchronized App getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getScreenSize();
        TLog.init(BuildConfig.DEBUG);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        mRefWatcher = LeakCanary.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * 内存泄漏检测对象
     *
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        App app = (App) context.getApplicationContext();
        return app.mRefWatcher;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    public void addActivity(Activity act) {
        if (mActivitysSet == null) {
            mActivitysSet = new HashSet<>();
        }
        mActivitysSet.add(act);
    }

    public void removeActivity(Activity act) {
        if (mActivitysSet != null) {
            mActivitysSet.remove(act);
        }
    }


    /**
     * 退出App
     */
    public void exitApp() {
        if (mActivitysSet != null) {
            synchronized (mActivitysSet) {
                for (Activity act : mActivitysSet) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
