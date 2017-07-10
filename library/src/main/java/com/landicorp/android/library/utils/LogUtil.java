package com.landicorp.android.library.utils;

import android.util.Log;

import com.landicorp.android.library.BuildConfig;

/**
 * Created by codeest on 2016/8/3.
 */
public class LogUtil {

    public static boolean isDebug = BuildConfig.DEBUG;

    public static void e(String s) {
//        if(isDebug) {
//            Logger.e(s);
//        }
    }

    public static void w(String s) {
//        if(isDebug) {
//            Logger.w(s);
//        }
    }


    public static void d(String s) {
//        if(isDebug) {
//            Logger.d(s);
//        }
        Log.d("LogUtil",s);
    }

    public static void i(String s) {
//        if(isDebug) {
//            Logger.i(s);
//        }
    }
}
