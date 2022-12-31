package com.darma1budi.myflexiblefragment_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnCategory = view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_category) {

            FragmentManager mFragmentManager = getParentFragmentManager(); // Pada Fragment - Fragment Manager menggunakan ParentFragmentManager
            CategoryFragment mCategoryFragment = new CategoryFragment();

            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, mCategoryFragment, CategoryFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }
    }
}