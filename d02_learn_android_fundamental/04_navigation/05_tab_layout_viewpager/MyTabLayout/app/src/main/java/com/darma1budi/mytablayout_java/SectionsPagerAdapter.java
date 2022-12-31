package com.darma1budi.mytablayout_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// class viewPager2 (fitur swipe pada tab layout)
public class SectionsPagerAdapter extends FragmentStateAdapter {

    // mengirimkan data dari activity ke fragment (fungsi untuk menangkap data dari activity)
    String appName;
    public void setAppName(String appName) {
        this.appName = appName;
    }

    public SectionsPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ProfileFragment();
                break;
        }

        // variable untuk Tab Layout With One Fragment
//        HomeFragment fragment = new HomeFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(HomeFragment.ARG_SECTION_NUMBER, position+1);
        // mengirimkan data dari activity ke fragment (mengirim data ke fragment)
//        bundle.putString(HomeFragment.ARG_NAME, appName);
//        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2; // jumlah tab
    }
}