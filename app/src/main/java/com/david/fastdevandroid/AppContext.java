package com.david.fastdevandroid;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/14.
 */

public class AppContext extends Application {
    private static AppContext instance;

    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
