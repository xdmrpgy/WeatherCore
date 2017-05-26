package com.landicorp.android.library.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Description:	Activity栈管理器
 * @author panguangyi
 * @date 2016年10月18日 下午3:11:00
 */
public class ActivityUtil {
    //初始化活动集合
	public static List<Activity> activities = new ArrayList<Activity>();
    //添加新的活动
	public static void addActivity(Activity activity) {
		//先判断list集合里是否已有该活动
		if(!activities.contains(activity)){
			activities.add(activity);
		}
		
	}
    //移除指定的活动
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
    //移除所有的活动
	public static void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}

	public static void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment, int frameId) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(frameId, fragment);
		transaction.commit();
	}
}
