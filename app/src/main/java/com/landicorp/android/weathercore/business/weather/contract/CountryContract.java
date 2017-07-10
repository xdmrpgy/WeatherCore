package com.landicorp.android.weathercore.business.weather.contract;

import com.landicorp.android.library.base.BasePresenter;
import com.landicorp.android.library.base.BaseView;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Country;

import java.util.List;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/3.
 */

public interface CountryContract {
    interface View extends BaseView<Presenter> {
        void showCountries(List<Country> countries);
        void showError(String msg);
    }

    interface Presenter extends BasePresenter {
        void loadCountries(String provinceId,String cityId);
    }
}
