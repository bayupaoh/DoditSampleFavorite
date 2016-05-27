package com.emergency.doditcoba.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emergency.doditcoba.Model.ModelMateri;
import com.emergency.doditcoba.R;

import java.util.ArrayList;

/**
 * Created by CodeLabs on 28/05/2016.
 */
public class AdapterMateriFavorite extends RecyclerView.Adapter<AdapterMateriFavorite.ViewHolder> {

    ArrayList<ModelMateri> listModelMateri;
    Context context;

    public AdapterMateriFavorite(ArrayList<ModelMateri> listModelMateri) {
        this.listModelMateri = listModelMateri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materifavorit, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.background.setImageResource(listModelMateri.get(position).getBackground());
        holder.judul.setText(listModelMateri.get(position).getJudul());
        holder.desc.setText(listModelMateri.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return listModelMateri.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView judul;
        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            background = (ImageView) itemView.findViewById(R.id.img_item_backdround);
            judul = (TextView) itemView.findViewById(R.id.txt_item_judul);
            desc = (TextView) itemView.findViewById(R.id.txt_item_desc);
        }
    }
}
