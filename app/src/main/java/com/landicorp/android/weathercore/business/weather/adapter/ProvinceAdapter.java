package com.landicorp.android.weathercore.business.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landicorp.android.library.base.BaseRecyclerViewAdapter;
import com.landicorp.android.weathercore.R;
import com.landicorp.android.weathercore.business.weather.model.http.entities.Province;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/6/2.
 */

public class ProvinceAdapter extends BaseRecyclerViewAdapter<ProvinceAdapter.ViewHolder> {

    public  List<Province > provinceList;

    public ProvinceAdapter(List<Province> provinces) {
        this.provinceList = provinces;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_province,parent,false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Province p = provinceList.get(position);
        holder.tvProvince.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return provinceList == null ? 0 : provinceList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_province)
        TextView tvProvince;
        public ViewHolder(View itemView, final ProvinceAdapter adapter) {
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
