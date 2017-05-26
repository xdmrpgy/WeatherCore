package com.landicorp.android.weathercore.business.weather.model.http.api;

import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by panguangyi on 2017-05-25.
 */

public interface WeatherApi {

    @GET("china")
    Observable<Province> getAddressList();
}
