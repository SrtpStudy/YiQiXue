package com.cslaker.study.utils;

import android.app.Application;
import android.content.Context;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by CSLaker on 2017/5/2.
 */

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        sContext = getApplicationContext();
        ShareSDK.initSDK(this);
    }

    public static Context getContext() {
        return  sContext;
    }

}
