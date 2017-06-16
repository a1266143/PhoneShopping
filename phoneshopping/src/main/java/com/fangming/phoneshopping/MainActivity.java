package com.fangming.phoneshopping;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.widget.ImageButton;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.fangming.phoneshopping.Activity.SearchActivity;
import com.fangming.phoneshopping.Base.BaseMapActivity;
import com.fangming.phoneshopping.Dagger.Component.DaggerMainComponent;
import com.fangming.phoneshopping.Dagger.Module.MainModule;
import com.kogitune.activity_transition.ActivityTransitionLauncher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMapActivity {

    @Inject
    LocationClient mLocationClient;
    @Inject
    BDLocationListener listener;
    @Inject
    MyLocationConfiguration configuration;
    @Inject
    MyLocationData.Builder builder;

    @BindView(R.id.activity_main_cvSearch)
    CardView cv_search;
    @BindView(R.id.activity_main_ibMenu)
    ImageButton ib_menu;

    /**
     * 获取到定位信息
     *
     * @param location 位置对象
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getLocationEvent(BDLocation location) {
        getLocation(location);
    }

    @OnClick(R.id.activity_main_btnSearch)
    void onClick() {
        Intent intent = new Intent(this,SearchActivity.class);
        ActivityTransitionLauncher.with(MainActivity.this).from(cv_search).launch(intent);
    }

    @OnClick(R.id.activity_main_ibMenu)
    void ibMenu(){
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMapId() {
        return R.id.bmapView;
    }

    @Override
    protected void init() {
        initDaggerAndOther();
        startLocation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initDaggerAndOther() {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
        DaggerMainComponent.builder().mainModule(new MainModule(getApplicationContext())).build().inject(this);
    }

    private void startLocation() {
        mLocationClient.registerLocationListener(listener);
        mLocationClient.start();
    }

    private void getLocation(BDLocation location){
        mBaiduMap.setMyLocationEnabled(true);
        MyLocationData locationData = builder.accuracy(location.getRadius())
                .direction(location.getDirection())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude()).build();
        mBaiduMap.setMyLocationConfiguration(configuration);
        mBaiduMap.setMyLocationData(locationData);
    }
}
