package com.bawei.sunshuaixi20200302.base;

import android.app.Application;
import android.content.Context;

/**
 * TIme:2020/3/2
 * Author:孙帅喜
 * Descriotion:
 */
public class App extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    public static Context getAppContext(){
        return applicationContext;
    }
}
