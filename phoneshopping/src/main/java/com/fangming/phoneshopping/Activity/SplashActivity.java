package com.fangming.phoneshopping.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.fangming.phoneshopping.Dagger.Component.DaggerSplComponent;
import com.fangming.phoneshopping.Dagger.Module.SplModule;
import com.fangming.phoneshopping.MainActivity;
import com.fangming.phoneshopping.R;
import com.fangming.phoneshopping.Utils;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.activity_splash_viewPager)
    ViewPager viewPager;
    @BindView(R.id.activity_splash_closeButton)
    Button closeButton;
    @OnClick(R.id.activity_splash_closeButton)
    void close(){
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        finish();
    }
    @Inject
    FragmentPagerAdapter pagerAdapter;
    @Inject
    ViewPager.OnPageChangeListener pageChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.fullScreen(this);
        setContentView(R.layout.activity_splash);
        setDaggerAndButterKnife();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }

    private void setDaggerAndButterKnife(){
        ButterKnife.bind(this);
        DaggerSplComponent.builder().splModule(new SplModule(getSupportFragmentManager(),closeButton)).build().inject(this);
    }
}
