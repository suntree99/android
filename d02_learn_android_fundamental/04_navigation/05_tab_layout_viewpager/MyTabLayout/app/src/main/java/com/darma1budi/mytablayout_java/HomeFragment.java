package com.darma1budi.mytablayout_java;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    // variable untuk Tab Layout With One Fragment
    static final String ARG_SECTION_NUMBER = "section_number";

    // mengirimkan data dari activity ke fragment (variable untuk menangkap data)
    public static final String ARG_NAME = "app_name";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // fungi untuk Tab Layout With One Fragment
    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView textView = view.findViewById(R.id.section_label);

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);

            // mengirimkan data dari activity ke fragment (menangkap data yang dikirimkan)
            String appName = getArguments().getString(ARG_NAME);

            // menampilkan text dengan template dan mengonsumsi data yang dikrimkan
            textView.setText(getString(R.string.content_tab_text, index) + " - " + appName);
        }
    }
}