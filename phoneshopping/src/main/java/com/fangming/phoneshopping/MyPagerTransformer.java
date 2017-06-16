package com.fangming.phoneshopping;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by 李晓军 on 2017/6/1.
 */

public class MyPagerTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            // This page is way off-screen to the left.
            //view.setAlpha(1);
        }
        else if (position <= 0) { // (0,1]
            Log.e("xiaojun","position <= 1");
            // Fade the page out.
            //view.setAlpha(1 - position);

            // Counteract the default slide transition
            //view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        }else if (position <= 1) { // (0,1]
            Log.e("xiaojun","position <=1");
            // Fade the page out.
            //view.setAlpha(1 - position);

            // Counteract the default slide transition
            //view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        }else{
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
        }
    }
}
