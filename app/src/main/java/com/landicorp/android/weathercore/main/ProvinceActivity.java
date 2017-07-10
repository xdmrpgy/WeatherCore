package com.landicorp.android.weathercore.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.landicorp.android.library.base.BaseActivity;
import com.landicorp.android.library.utils.LogUtil;
import com.landicorp.android.library.utils.SnackbarUtil;
import com.landicorp.android.weathercore.R;
import com.landicorp.android.weathercore.business.weather.adapter.ProvinceAdapter;
import com.landicorp.android.weathercore.business.weather.contract.ProvinceContract;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;
import com.landicorp.android.weathercore.business.weather.presenter.ProvincePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProvinceActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,ProvinceContract.View{
    @BindView(R.id.navigation)
    NavigationView navigationView;
    @BindView(R.id.rv_provinces)
    RecyclerView rvProvinces;
    @BindView(R.id.toolbar)
    Toolbar mToolBar;


    private List<Province> provinceList = new ArrayList<Province>();
    private ProvinceAdapter provinceAdapter;
    private ProvincePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_favorite:
                        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0),"favorite");
                        break;
                    case R.id.menu_photo:
                        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0),"photo");
                        break;
                    case R.id.menu_settings:
                        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0),"settings");
                        break;
                }
                return true;
            }
        });

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvProvinces.setLayoutManager(linearLayoutManager);
        provinceAdapter = new ProvinceAdapter(provinceList);
        rvProvinces.setAdapter(provinceAdapter);
        rvProvinces.setItemAnimator(new DefaultItemAnimator());
        rvProvinces.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        provinceAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Province p = provinceAdapter.provinceList.get(position);
//                SnackbarUtil.show(ProvinceActivity.this,p.getName());
                Intent i = new Intent(ProvinceActivity.this,CityActivity.class);
                i.putExtra(CityActivity.PROVINCE_KEY,p.getId() + "");
                LogUtil.d("pId:" + p.getId());
                startActivity(i);
            }
        });

        presenter = new ProvincePresenter(this,this);
        presenter.subscribe();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navigation_items,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_favorite:
                SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0),"favorite");
                break;
            case R.id.menu_photo:
                SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0),"photo");
                break;
            case R.id.menu_settings:
                SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0),"settings");
                break;
        }
        return true;
    }

    @Override
    public void setPresenter(ProvinceContract.Presenter presenter) {

   }

    @Override
    public void showError(String msg) {
        SnackbarUtil.show(this,msg);
    }

    @Override
    public void showProvinces(List<Province> provinces) {
        this.provinceList.addAll(provinces);
        provinceAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribe();
    }
}
