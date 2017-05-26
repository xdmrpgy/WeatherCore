package com.landicorp.android.library.base;

import java.lang.ref.WeakReference;

import android.os.Handler;
import android.os.Message;

/**
 * Description:	自定义handler子类，使用弱引用保存外部类的引用，防止内存泄漏
 * @author panguangyi
 * @date 2016年12月21日 下午1:32:08
 * @param <T> handler的外部容器类
 */
public class SafeHandler<T extends SafeHandler.HandlerContainer> extends Handler {
	protected WeakReference<T> mRef;
	public SafeHandler(WeakReference<T> ref) {
		mRef = ref;
	}
	
	public SafeHandler(T obj) {
		mRef = new WeakReference<T>(obj);
	}
	
	public T getContainer() {
		return mRef.get();
	}
	
	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		HandlerContainer container = getContainer();
		if (container != null) {
			container.handleMessage(msg);
		}
	}
	
	/**
	 * 表示Handler所在的容器(类), 通常是Activity或Fragment.
	 */
	public interface HandlerContainer{
		void handleMessage(Message msg);
	}
}
