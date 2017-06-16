package com.fangming.phoneshopping.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fangming.phoneshopping.R;

import butterknife.BindView;

/**
 * Created by 李晓军 on 2017/6/12.
 */

public class Fragment1 extends BaseFragment {

    @BindView(R.id.fragmentTV)
    TextView tv;

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment1,container,false);
    }

    @Override
    protected void init() {
        tv.setText("欢迎界面1");
    }
}
