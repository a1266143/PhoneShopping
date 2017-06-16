package com.fangming.phoneshopping.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by 李晓军 on 2017/6/12.
 */

public abstract class BaseFragment extends Fragment {

    private static final String ARGUMENT = "argument";
    //Fragment参数
    protected String mArgument;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null)
            mArgument = bundle.getString(ARGUMENT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutView(inflater,container,savedInstanceState);
        ButterKnife.bind(this,view);
        init();
        return view;
    }

    protected abstract View getLayoutView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState);
    protected abstract void init();

    /**
     * 创建此Fragment或者子Fragment的实例
     * @param argument 参数
     * @return 返回Fragment实例
     */
    /*public static BaseFragment newInstance(String argument,Class<? extends BaseFragment> instance){
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, argument);
        BaseFragment contentFragment = instance;
        contentFragment.setArguments(bundle);
        return contentFragment;
    }*/
}
