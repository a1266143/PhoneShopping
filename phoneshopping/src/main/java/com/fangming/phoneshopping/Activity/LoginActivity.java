package com.fangming.phoneshopping.Activity;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fangming.phoneshopping.Dagger.Component.DaggerLoginComponent;
import com.fangming.phoneshopping.Dagger.Module.LoginModule;
import com.fangming.phoneshopping.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    public static final String LOGIN_SUCCESS = "success_login";

    @Inject
    MaterialDialog.Builder loginDialogBuilder;
    @Inject
    Handler handler;
    @Inject
    Runnable mRunnable;
    @Named("finishDialog")
    @Inject
    MaterialDialog.Builder finishDialogBuilder;

    @BindView(R.id.activity_login_btnLogin)
    Button btn_login;

    private MaterialDialog loginDialog;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void cancelEvent(DialogInterface dialog){//接收到对话框被取消的事件
        handler.removeCallbacks(mRunnable);
        btn_login.setEnabled(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loginSuccess(String string){
        if(TextUtils.equals(string,LOGIN_SUCCESS)){
            loginDialog.dismiss();
            btn_login.setEnabled(false);
            finish();
        }
    }

    @OnClick(R.id.activity_login_btnLogin)
    void login(){
        btn_login.setEnabled(false);
        handler.postDelayed(mRunnable,2000);
        loginDialog = loginDialogBuilder.show();
    }

    @OnClick(R.id.activity_login_ibBack)
    void back(){
        finishDialogBuilder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
