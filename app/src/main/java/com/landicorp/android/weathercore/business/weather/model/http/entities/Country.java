package com.landicorp.android.weathercore.business.weather.model.http.entities;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/5/26.
 */

public class Country {

    /**
     * id : 1
     * name : 北京
     */

    private int id;
    private String name;
    private String weather_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }
}
