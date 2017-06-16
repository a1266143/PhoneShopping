package com.fangming.phoneshopping.Dagger.Component;

import com.fangming.phoneshopping.Activity.SplashActivity;
import com.fangming.phoneshopping.Dagger.Module.SplModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 李晓军 on 2017/6/12.
 */
@Singleton
@Component(modules = SplModule.class)
public interface SplComponent {
    void inject(SplashActivity activity);
}
