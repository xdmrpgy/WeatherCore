package com.landicorp.android.library.utils;

import com.landicorp.android.library.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by codeest on 2016/8/3.
 */
public class LogUtil {

    public static boolean isDebug = BuildConfig.DEBUG;

    public static void e(String tag,Object o) {
        if(isDebug) {
            Logger.e(tag, o);
        }
    }

    public static void w(String tag,Object o) {
        if(isDebug) {
            Logger.w(tag, o);
        }
    }


    public static void d(String tag,String msg) {
        if(isDebug) {
            Logger.d(tag,msg);
        }
    }

    public static void i(String tag,String msg) {
        if(isDebug) {
            Logger.i(tag,msg);
        }
    }
}
