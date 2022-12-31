package com.darma1budi.myrecyclerviewwithviewbinding_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true); // true berarti recyclerView dapat melakukan optimasi ukuran lebar dan tinggi secara otomatis

        list.addAll(getListHeroes());
        showRecyclerList();
    }

    public ArrayList<Hero> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        ArrayList<Hero> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(hero);
        }
        return listHero;
    }

    private void showRecyclerList(){

        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /** Layout Grid - digunakan saat landscape */
            rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            /** Layout Linear - digunakan saat portrait */
            rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        }

        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);

        /** Pemanggilan onClick */
        listHeroAdapter.setOnItemClickCallback(data -> showSelectedHero(data));
    }

    /** Fungsi yang ditrigger onClick */
    private void showSelectedHero(Hero hero) {
        Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
    }
}