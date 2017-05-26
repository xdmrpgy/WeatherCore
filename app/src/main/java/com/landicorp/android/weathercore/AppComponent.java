package com.landicorp.android.weathercore;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by panguangyi on 2017-05-25.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getApplication();
    Context getContext();
}
