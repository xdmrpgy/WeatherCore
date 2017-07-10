package com.landicorp.android.weathercore.business.weather.presenter;

import com.landicorp.android.weathercore.business.weather.contract.CountryContract;
import com.landicorp.android.weathercore.business.weather.model.HttpData;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Country;

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

public class CountryPresenter implements CountryContract.Presenter {
    private CountryContract.View view;
    public CountryPresenter(CountryContract.View view){
        this.view = view;
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void loadCountries(String provinceId, String cityId) {
        HttpData.getSingleton().getCountries(new Observer<List<Country>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Country> countries) {
                view.showCountries(countries);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        },provinceId,cityId);
    }
}
