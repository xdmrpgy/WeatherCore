package com.landicorp.android.weathercore.business.weather.contract;

import com.landicorp.android.library.base.BasePresenter;
import com.landicorp.android.library.base.BaseView;
import com.landicorp.android.weathercore.business.weather.model.http.entities.WeatherInfo;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/3.
 */

public interface WeatherContract {
    interface View extends BaseView<Presenter> {
        void showWeahterInfo(WeatherInfo weather);
        void showError(String msg);
        void showBingPic(String url);
    }
    interface Presenter extends BasePresenter {
        void loadWeatherInfo(String weatherId);
        void loadBingPic();
    }
}
