package com.landicorp.android.library.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.landicorp.android.library.utils.LogUtil;

/**
 * Created by panguangyi on 2017-05-25.
 */

public class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(getClass().getSimpleName() + "onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d(getClass().getSimpleName() + "onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(getClass().getSimpleName() + "onDestroy");
    }
}
