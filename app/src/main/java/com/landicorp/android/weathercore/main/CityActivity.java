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
import com.landicorp.android.weathercore.business.weather.adapter.CityAdapter;
import com.landicorp.android.weathercore.business.weather.contract.CityContract;
import com.landicorp.android.weathercore.business.weather.model.http.entities.City;
import com.landicorp.android.weathercore.business.weather.presenter.CityPresenter;

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

public class CityActivity extends BaseActivity implements CityContract.View{
    public static final String PROVINCE_KEY = "cityId";
    @BindView(R.id.rv_cities)
    RecyclerView rvCities;

    private CityPresenter presenter;

    private List<City> cityList = new ArrayList<>();
    private CityAdapter cityAdapter;

    private String provinceId;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ButterKnife.bind(this);
        provinceId = getIntent().getStringExtra(PROVINCE_KEY);
        if (TextUtils.isEmpty(provinceId)){
            provinceId = "";
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCities.setLayoutManager(linearLayoutManager);
        cityAdapter = new CityAdapter(cityList);
        rvCities.setAdapter(cityAdapter);
        rvCities.setItemAnimator(new DefaultItemAnimator());
        rvCities.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        cityAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                City city = cityList.get(position);
                Intent i = new Intent(CityActivity.this,CountryActivity.class);
                i.putExtra(CountryActivity.PROVINCE_KEY,provinceId + "");
                i.putExtra(CountryActivity.CITY_KEY,city.getId() + "");
                startActivity(i);
            }
        });

        presenter = new CityPresenter(this);
        presenter.loadCities(provinceId);
    }

    @Override
    public void setPresenter(CityContract.Presenter presenter) {

    }

    @Override
    public void showCities(List<City> cities) {
        cityList.addAll(cities);
        cityAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.show(this,msg);
    }
}
