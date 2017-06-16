package com.fangming.phoneshopping;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by 李晓军 on 2017/6/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //百度地图SDK初始化
        SDKInitializer.initialize(getApplicationContext());
    }
}
