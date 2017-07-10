package com.landicorp.android.weathercore.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.landicorp.android.library.base.BaseActivity;
import com.landicorp.android.library.utils.SnackbarUtil;
import com.landicorp.android.weathercore.R;
import com.landicorp.android.weathercore.business.weather.contract.WeatherContract;
import com.landicorp.android.weathercore.business.weather.model.http.entities.WeatherInfo;
import com.landicorp.android.weathercore.business.weather.presenter.WeatherPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/3.
 */

public class WeatherActivity extends BaseActivity implements WeatherContract.View{
    public static final String WEATHER_ID = "weatherId";
    @BindView(R.id.tv_city_name)
    TextView tvCityName;
    @BindView(R.id.tv_update_time)
    TextView tvUpdateTime;
    @BindView(R.id.tv_degree)
    TextView tvDegree;
    @BindView(R.id.tv_weather_info)
    TextView tvWeatherInfo;
    @BindView(R.id.ll_forecast)
    LinearLayout llForecast;
    @BindView(R.id.tv_aqi)
    TextView tvAqi;
    @BindView(R.id.tv_pm25)
    TextView tvPm25;
    @BindView(R.id.tv_comfort)
    TextView tvComfort;
    @BindView(R.id.tv_car_wash)
    TextView tvCarWash;
    @BindView(R.id.tv_sport)
    TextView tvSport;
    @BindView(R.id.iv_bing)
    ImageView ivBing;

    private WeatherPresenter presenter;
    private String weatherId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        weatherId = getIntent().getStringExtra(WEATHER_ID);
        if (TextUtils.isEmpty(weatherId)){
            weatherId = "";
        }
        presenter = new WeatherPresenter(this);
        presenter.loadWeatherInfo(weatherId);
        presenter.loadBingPic();
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {

    }

    @Override
    public void showWeahterInfo(WeatherInfo weather) {
        tvCityName.setText(weather.getWeatherInfo().getBasic().getCity());
        tvUpdateTime.setText(weather.getWeatherInfo().getBasic().getUpdate().getLoc().split(" ")[1]);
        tvDegree.setText(weather.getWeatherInfo().getNow().getTmp() + "'C");
        tvWeatherInfo.setText(weather.getWeatherInfo().getNow().getCond().getTxt());
        llForecast.removeAllViews();
        for (WeatherInfo.HeWeatherBean.DailyForecastBean forecastBean : weather.getWeatherInfo().getDaily_forecast()) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_ll_forecast,llForecast,false);
            TextView tvDate = (TextView) view.findViewById(R.id.tv_date);
            TextView tvInfo = (TextView) view.findViewById(R.id.tv_info);
            TextView tvMax = (TextView) view.findViewById(R.id.tv_max);
            TextView tvMin = (TextView) view.findViewById(R.id.tv_min);
            tvDate.setText(forecastBean.getDate());
            tvInfo.setText(forecastBean.getCond().getTxt_d());
            tvMax.setText(forecastBean.getTmp().getMax());
            tvMin.setText(forecastBean.getTmp().getMin());
            llForecast.addView(view);
        }
        tvAqi.setText(weather.getWeatherInfo().getAqi().getCity().getAqi());
        tvPm25.setText(weather.getWeatherInfo().getAqi().getCity().getPm25());
        tvComfort.setText("舒适度:" + weather.getWeatherInfo().getSuggestion().getComf().getTxt());
        tvCarWash.setText("洗车指数:" + weather.getWeatherInfo().getSuggestion().getCw().getTxt());
        tvSport.setText("运动指数:" + weather.getWeatherInfo().getSuggestion().getSport().getTxt());
    }

    @Override
    public void showBingPic(String url) {
        Glide.with(this).load(url).into(ivBing);
    }


    @Override
    public void showError(String msg) {
        SnackbarUtil.show(this,msg);
    }
}
