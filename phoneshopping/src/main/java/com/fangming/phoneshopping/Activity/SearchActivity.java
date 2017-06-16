package com.fangming.phoneshopping.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.fangming.phoneshopping.R;
import com.kogitune.activity_transition.ActivityTransition;
import com.kogitune.activity_transition.ExitActivityTransition;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索界面
 */
public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.activity_search_cvSearch)
    CardView cv_search;
    private ExitActivityTransition exitActivityTransition;

    @OnClick(R.id.activity_search_ibBack)
    void back() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        exitActivityTransition = ActivityTransition.with(getIntent()).to(cv_search).start(savedInstanceState);
    }

}
