package com.landicorp.android.weathercore.business.weather.model.http.api;

import com.landicorp.android.weathercore.business.weather.model.http.entities.City;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Country;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;
import com.landicorp.android.weathercore.business.weather.model.http.entities.WeatherInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by panguangyi on 2017-05-25.
 */

public interface WeatherApi {
    @GET("china")
    Observable<List<Province> > getProvinces();

    @GET("china/{provinceId}")
    Observable<List<City> > getCities(@Path("provinceId")String provinceId);

    @GET("china/{provinceId}/{cityId}")
    Observable<List<Country> > getCountries(@Path("provinceId")String provinceId,@Path("cityId")String cityId);

    @GET("weather")
    Observable<WeatherInfo> getHeWeather(@Query("cityid")String cityid, @Query("key")String key);

    @GET("bing_pic")
    Observable<String> getBingPicUrl();

}
