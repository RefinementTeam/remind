package com.remind;

import android.app.Application;
import android.content.Context;

public class RemindApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        RemindApplication.context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
