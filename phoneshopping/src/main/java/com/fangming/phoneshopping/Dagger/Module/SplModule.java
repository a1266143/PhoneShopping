package com.fangming.phoneshopping.Dagger.Module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.fangming.phoneshopping.Fragment.BaseFragment;
import com.fangming.phoneshopping.Fragment.Fragment1;
import com.fangming.phoneshopping.Fragment.Fragment2;
import com.fangming.phoneshopping.Fragment.Fragment3;
import com.fangming.phoneshopping.Fragment.Fragment4;
import com.fangming.phoneshopping.Fragment.Fragment5;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 李晓军 on 2017/6/12.
 */

@Module
public class SplModule {

    private FragmentManager manager;
    private Button closeButton;

    public SplModule(FragmentManager manager,Button closeButton){
        this.manager = manager;
        this.closeButton = closeButton;
    }

    @Singleton
    @Provides
    public FragmentPagerAdapter providerFragmentPagerAdapter(final List<Fragment> list) {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };
        return adapter;
    }

    @Singleton
    @Provides
    public List<Fragment> providerFragmentList(){
        List<Fragment> list = new ArrayList<>();
        BaseFragment fragment1 = new Fragment1();
        BaseFragment fragment2 = new Fragment2();
        BaseFragment fragment3 = new Fragment3();
        BaseFragment fragment4 = new Fragment4();
        BaseFragment fragment5 = new Fragment5();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);
        return list;
    }

    @Singleton
    @Provides
    public ViewPager.OnPageChangeListener providerOnPageChangeListener(){
        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 4){
                    closeButton.setVisibility(View.VISIBLE);
                }else{
                    closeButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        return listener;
    }
}
