package com.darma1budi.mytablayout_java;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    // judul untuk setiap tab
    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2,
//            R.string.tab_text_3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // menghubungan viewpager2 dengan tab layout
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        // mengirimkan data dari activity ke fragment (kirim dulu ke page adapter)
        sectionsPagerAdapter.setAppName(getResources().getString(R.string.delivered));

        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager, (tab, position) ->
                tab.setText(getResources().getString(TAB_TITLES[position]))
        ).attach();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}