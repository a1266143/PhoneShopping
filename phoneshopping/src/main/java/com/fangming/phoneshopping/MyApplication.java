package com.fangming.phoneshopping;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 李晓军 on 2017/6/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //百度地图SDK初始化
        SDKInitializer.initialize(getApplicationContext());
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
