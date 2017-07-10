package com.landicorp.android.weathercore.business.weather.presenter;

import com.landicorp.android.weathercore.business.weather.contract.CityContract;
import com.landicorp.android.weathercore.business.weather.model.HttpData;
import com.landicorp.android.weathercore.business.weather.model.http.entities.City;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/3.
 */

public class CityPresenter implements CityContract.Presenter {
    private CityContract.View view;

    public CityPresenter(CityContract.View view) {
        this.view = view;
    }
    @Override
    public void subscribe() {
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void loadCities(String provinceId) {
        HttpData.getSingleton().getCities(new Observer<List<City>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<City> cities) {
                view.showCities(cities);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError("加载失败～～");
            }

            @Override
            public void onComplete() {

            }
        },provinceId);
    }
}
