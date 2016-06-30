package com.dayi.app;

import android.app.Application;

/**
 * Created by zhilian-2 on 2016/1/16.
 */
public class AppApplacation extends Application{

    private static AppApplacation instance = null;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized AppApplacation getInstance() {
        return instance;
    }
}
