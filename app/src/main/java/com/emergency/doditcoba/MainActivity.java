package com.emergency.doditcoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.emergency.doditcoba.Adapter.AdapterMateri;
import com.emergency.doditcoba.Model.ModelMateri;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelMateri> listModalMateri = new ArrayList<>();
    Button btnFavorit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declarationWidget();
        setDatadummy();
        setRecyclerview();
    }

    private void setRecyclerview() {
        AdapterMateri adapterMateri = new AdapterMateri(listModalMateri,this);
        recyclerView.setAdapter(adapterMateri);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setDatadummy() {
        listModalMateri.add(new ModelMateri(R.drawable.backgrounds,"Bayu","Kepeppepepe"));
        listModalMateri.add(new ModelMateri(R.drawable.backgrounds,"Bayu","Kepeppepepe"));
        listModalMateri.add(new ModelMateri(R.drawable.backgrounds,"Bayu","Kepeppepepe"));
        listModalMateri.add(new ModelMateri(R.drawable.backgrounds,"Bayu","Kepeppepepe"));
    }

    private void declarationWidget() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_main_listmateri);
        btnFavorit = (Button) findViewById(R.id.btn_main_favorite);
        btnFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FavoriteActivity.class);
                startActivity(i);
            }
        });
    }
}
