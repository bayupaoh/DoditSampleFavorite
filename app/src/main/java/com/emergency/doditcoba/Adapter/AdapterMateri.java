package com.emergency.doditcoba.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.emergency.doditcoba.Model.ModelMateri;
import com.emergency.doditcoba.R;
import com.emergency.doditcoba.Util.SessionManager;

import java.util.ArrayList;

/**
 * Created by CodeLabs on 28/05/2016.
 */
public class AdapterMateri extends RecyclerView.Adapter<AdapterMateri.ViewHolder> {

    ArrayList<ModelMateri> listModelMateri;
    Context context;

    public AdapterMateri(ArrayList<ModelMateri> listModelMateri, Context context) {
        this.listModelMateri = listModelMateri;
        this.context = context;
    }

    public AdapterMateri(ArrayList<ModelMateri> modelMateri) {
        this.listModelMateri = modelMateri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materi, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.background.setImageResource(listModelMateri.get(position).getBackground());
        holder.judul.setText(listModelMateri.get(position).getJudul());
        holder.desc.setText(listModelMateri.get(position).getDesc());
        holder.buttonFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Klik fav","klik : "+listModelMateri.get(position).getJudul());
                holder.buttonFavorit.setImageResource(R.drawable.love);
                SessionManager sessionManager = new SessionManager();

                sessionManager.addFavorite(context,listModelMateri.get(position));
                Toast.makeText(context,"Save data berhasil",Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return listModelMateri.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView background;
        TextView judul;
        TextView desc;
        ImageView buttonFavorit;
        public ViewHolder(View itemView) {
            super(itemView);
            background = (ImageView) itemView.findViewById(R.id.img_item_backdround);
            judul = (TextView) itemView.findViewById(R.id.txt_item_judul);
            desc = (TextView) itemView.findViewById(R.id.txt_item_desc);
            buttonFavorit = (ImageView) itemView.findViewById(R.id.img_item_fav);
        }

    }
}
