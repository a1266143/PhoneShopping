package com.fangming.phoneshopping.Dagger.Module;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fangming.phoneshopping.Activity.LoginActivity;
import com.fangming.phoneshopping.MainActivity;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 创建人 xiaojun
 * 创建时间 2017/6/16-16:53
 */
@Module
public class LoginModule {

    private Context context;

    public LoginModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public MaterialDialog.Builder providerMaterialDialog() {//返回登录对话框
        return new MaterialDialog.Builder(context).title("登录")
                .content("正在登录，请稍后...")
                .progress(true, 0)
                .cancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        EventBus.getDefault().post(dialog);
                    }
                });
    }

    @Singleton
    @Provides
    public Handler providerHandler() {
        Handler handler = new Handler();
        return handler;
    }

    @Singleton
    @Provides
    public Runnable providerRunnable() {
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                context.startActivity(new Intent(context, MainActivity.class));
                EventBus.getDefault().post(LoginActivity.LOGIN_SUCCESS);
            }
        };
        return mRunnable;
    }

    @Named("finishDialog")
    @Singleton
    @Provides
    public MaterialDialog.Builder providerFinishDialogBuilder(){
        return new MaterialDialog.Builder(context).title("退出")
                .content("确认退出手机逛街吗？")
                .positiveText("确定")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        ((AppCompatActivity)context).finish();
                    }
                })
                .negativeText("取消");
    }
}
