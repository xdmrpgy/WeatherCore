package com.landicorp.android.weathercore.business.weather.presenter;

import com.landicorp.android.weathercore.business.weather.contract.WeatherContract;
import com.landicorp.android.weathercore.business.weather.model.HttpData;
import com.landicorp.android.weathercore.business.weather.model.http.entities.WeatherInfo;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/3.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    private WeatherContract.View view;
    public WeatherPresenter(WeatherContract.View view){
        this.view = view;
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void loadWeatherInfo(String weatherId) {
        HttpData.getSingleton().getHeWeather(new Observer<WeatherInfo>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull WeatherInfo weather) {
                view.showWeahterInfo(weather);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        },weatherId);
    }

    @Override
    public void loadBingPic() {
        HttpData.getSingleton().getBingPicUrl(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                view.showBingPic(s);
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
