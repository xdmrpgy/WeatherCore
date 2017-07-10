package com.landicorp.android.weathercore.business.weather.presenter;

import android.content.Context;

import com.landicorp.android.weathercore.AppModule;
import com.landicorp.android.weathercore.business.weather.contract.ProvinceContract;
import com.landicorp.android.weathercore.business.weather.model.HttpData;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;
import com.landicorp.android.weathercore.utils.ActivityScoped;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/2.
 */
@ActivityScoped
public class ProvincePresenter implements ProvinceContract.Presenter {
    private  ProvinceContract.View view;
    private static final String TAG = "ProvincePresenter";
    @Inject
    public ProvincePresenter(Context context,ProvinceContract.View view){
        this.view = view;
        DaggerPresenterComponent.builder().appModule(new AppModule(context)).build().inject(this);

    }

    @Override
    public void subscribe() {
        loadProvinces();
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void loadProvinces() {
        HttpData.getSingleton().getProvinces(new Observer<List<Province>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Province> provinces) {
                view.showProvinces(provinces);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError("加载失败！请重新加载～～");
            }

            @Override
            public void onComplete() {

            }
        });
    }


}
