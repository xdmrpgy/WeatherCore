package com.landicorp.android.weathercore;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by panguangyi on 2017-05-25.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return (App)context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {

        return context;
    }
}
