package com.fangming.phoneshopping.Dagger.Component;

import com.fangming.phoneshopping.Activity.LoginActivity;
import com.fangming.phoneshopping.Dagger.Module.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建人 xiaojun
 * 创建时间 2017/6/16-17:01
 */
@Singleton
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
