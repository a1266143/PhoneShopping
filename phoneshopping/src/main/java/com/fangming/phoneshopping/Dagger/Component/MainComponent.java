package com.fangming.phoneshopping.Dagger.Component;

import com.fangming.phoneshopping.Dagger.Module.MainModule;
import com.fangming.phoneshopping.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建人 xiaojun
 * 创建时间 2017/6/15-11:46
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
