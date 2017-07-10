package com.landicorp.android.weathercore.business.weather.contract;

import com.landicorp.android.library.base.BasePresenter;
import com.landicorp.android.library.base.BaseView;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;

import java.util.List;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/2.
 */

public interface ProvinceContract {
    interface View extends BaseView<Presenter> {
        void showProvinces(List<Province> provinces);
    }

    interface Presenter extends BasePresenter {
        void loadProvinces();
    }
}
