package com.landicorp.android.weathercore.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import com.landicorp.android.library.base.BaseActivity;
import com.landicorp.android.library.utils.SnackbarUtil;
import com.landicorp.android.weathercore.R;
import com.landicorp.android.weathercore.business.weather.adapter.CountryAdapter;
import com.landicorp.android.weathercore.business.weather.contract.CountryContract;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Country;
import com.landicorp.android.weathercore.business.weather.presenter.CountryPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/3.
 */

public class CountryActivity extends BaseActivity implements CountryContract.View{
    public static final String PROVINCE_KEY = "provinceId";
    public static final String CITY_KEY = "cityId";
    @BindView(R.id.rv_countries)
    RecyclerView rvCountries;

    private CountryPresenter presenter;

    private List<Country> countryList = new ArrayList<>();
    private CountryAdapter countryAdapter;

    private String provinceId;
    private String cityId;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);
        provinceId = getIntent().getStringExtra(PROVINCE_KEY);
        if (TextUtils.isEmpty(provinceId)){
            provinceId = "";
        }
        cityId = getIntent().getStringExtra(CITY_KEY);
        if (TextUtils.isEmpty(cityId)){
            cityId = "";
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCountries.setLayoutManager(linearLayoutManager);
        countryAdapter = new CountryAdapter(countryList);
        rvCountries.setAdapter(countryAdapter);
        rvCountries.setItemAnimator(new DefaultItemAnimator());
        rvCountries.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        countryAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = countryList.get(position);
                Intent i = new Intent(CountryActivity.this,WeatherActivity.class);
                i.putExtra(WeatherActivity.WEATHER_ID,country.getWeather_id());
                startActivity(i);
            }
        });

        presenter = new CountryPresenter(this);
        presenter.loadCountries(provinceId,cityId);
    }

    @Override
    public void setPresenter(CountryContract.Presenter presenter) {

    }

    @Override
    public void showCountries(List<Country> countries) {
        countryList.addAll(countries);
        countryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.show(this,msg);
    }
}
