package com.landicorp.android.weathercore.business.weather.presenter;

import com.landicorp.android.weathercore.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/2.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface PresenterComponent {
    void inject(ProvincePresenter presenter);
}
