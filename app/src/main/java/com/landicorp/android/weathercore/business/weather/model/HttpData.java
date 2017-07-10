package com.landicorp.android.weathercore.business.weather.model;

import com.landicorp.android.weathercore.business.weather.model.http.api.WeatherApi;
import com.landicorp.android.weathercore.business.weather.model.http.entities.City;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Country;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;
import com.landicorp.android.weathercore.business.weather.model.http.entities.WeatherInfo;
import com.landicorp.android.weathercore.utils.RxUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/5/26.
 */

public class HttpData {
    private WeatherApi weatherApi = ApiClient.initService(ApiConstants.BASE_URL, WeatherApi.class);

    private static class SingletonHodler{
        private static HttpData httpData = new HttpData();
    }

    public static HttpData getSingleton() {
        return SingletonHodler.httpData;
    }

    public void getProvinces(Observer<List<Province> > observer) {
        Observable observable = weatherApi.getProvinces();
        RxUtil.setSubscribe(observable,observer);
    }

    public void getCities(Observer<List<City> > observer,String provinceId) {
        Observable observable = weatherApi.getCities(provinceId);
        RxUtil.setSubscribe(observable,observer);
    }

    public void getCountries(Observer<List<Country> > observer,String provinceId,String cityId) {
        Observable observable = weatherApi.getCountries(provinceId,cityId);
        RxUtil.setSubscribe(observable,observer);
    }

    public void getHeWeather(Observer<WeatherInfo> observer, String weatherId) {
        Observable observable = weatherApi.getHeWeather(weatherId,ApiConstants.WEATHER_API_KEY);
        RxUtil.setSubscribe(observable,observer);
    }

    public void getBingPicUrl(Observer<String> observer){
        Observable observable = weatherApi.getBingPicUrl();
        RxUtil.setSubscribe(observable,observer);
    }
}
