package com.landicorp.android.weathercore.business.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landicorp.android.library.base.BaseRecyclerViewAdapter;
import com.landicorp.android.weathercore.R;
import com.landicorp.android.weathercore.business.weather.model.http.entities.City;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/2.
 */

public class CityAdapter extends BaseRecyclerViewAdapter<CityAdapter.ViewHolder> {

    public  List<City > CityList;

    public CityAdapter(List<City> Citys) {
        this.CityList = Citys;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_city,parent,false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City p = CityList.get(position);
        holder.tvCity.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return CityList == null ? 0 : CityList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_city)
        TextView tvCity;
        public ViewHolder(View itemView, final CityAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.onItemHolderClick(ViewHolder.this);
                }
            });
        }
    }
}
