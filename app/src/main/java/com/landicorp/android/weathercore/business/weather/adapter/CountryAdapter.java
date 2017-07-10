package com.landicorp.android.weathercore.business.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landicorp.android.library.base.BaseRecyclerViewAdapter;
import com.landicorp.android.weathercore.R;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Country;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/2.
 */

public class CountryAdapter extends BaseRecyclerViewAdapter<CountryAdapter.ViewHolder> {

    public  List<Country > CountryList;

    public CountryAdapter(List<Country> Countrys) {
        this.CountryList = Countrys;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_country,parent,false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country p = CountryList.get(position);
        holder.tvCountry.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return CountryList == null ? 0 : CountryList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_country)
        TextView tvCountry;
        public ViewHolder(View itemView, final CountryAdapter adapter) {
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
