package com.remind;

import android.app.Application;
import android.content.Context;

import keeplive.je.com.keeplivesupportlibrary.KeepLiveManager;

public class RemindApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        RemindApplication.context = getApplicationContext();
        //后台保活
        KeepLiveManager.INSTANCE.init(getApplicationContext());

    }

    public static Context getContext() {
        return context;
    }
}
