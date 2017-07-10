package com.landicorp.android.library.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.landicorp.android.library.utils.ActivityUtil;
import com.landicorp.android.library.utils.LogUtil;

/**
 * Created by panguangyi on 2017-05-25.
 */

public class BaseActivity  extends AppCompatActivity{

    /**
     * 解决Vector兼容性问题
     */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtil.addActivity(this);
        LogUtil.d(getClass().getSimpleName() + "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(getClass().getSimpleName() + "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(getClass().getSimpleName() + "onDestroy");
        ActivityUtil.removeActivity(this);
    }
}
