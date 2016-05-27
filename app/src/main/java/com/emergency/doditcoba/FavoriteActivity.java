package com.emergency.doditcoba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.emergency.doditcoba.Adapter.AdapterMateri;
import com.emergency.doditcoba.Adapter.AdapterMateriFavorite;
import com.emergency.doditcoba.Model.ModelMateri;
import com.emergency.doditcoba.Util.SessionManager;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelMateri> listModalMateri = new ArrayList<>();
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        declarationWidget();
        setDatadummy();
        setRecyclerview();
    }

    private void setRecyclerview() {
        if(listModalMateri != null && !listModalMateri.isEmpty()) {
            AdapterMateriFavorite adapterMateri = new AdapterMateriFavorite(listModalMateri);
            recyclerView.setAdapter(adapterMateri);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }else{
            Toast.makeText(getApplicationContext(),"Data Favorit Kososng",Toast.LENGTH_LONG).show();
        }
    }


    private void setDatadummy() {

        sessionManager = new SessionManager();
        listModalMateri = sessionManager.getFavorites(this);


    }

    private void declarationWidget() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_main_listfavorit);
    }
}
