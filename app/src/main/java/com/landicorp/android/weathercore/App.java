package com.landicorp.android.weathercore;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.Logger;

/**
 * Created by panguangyi on 2017-05-25.
 */

public class App extends Application {
    private static App instance;
    private static AppComponent appComponent;
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //初始化日志
        Logger.init(getPackageName()).hideThreadInfo();

        //初始化stetho调试工具
        Stetho.initializeWithDefaults(this);
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                                             .appModule(new AppModule(instance))
                                             .build();
        }
        return appComponent;
    }
}
