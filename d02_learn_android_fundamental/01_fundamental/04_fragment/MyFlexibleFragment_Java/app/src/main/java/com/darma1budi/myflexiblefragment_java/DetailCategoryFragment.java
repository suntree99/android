package com.darma1budi.myflexiblefragment_java;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailCategoryFragment extends Fragment {

    private TextView tvCategoryName;
    private TextView tvCategoryDescription;
    private Button btnProfile;
    private Button btnShowDialog;

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESCRIPTION = "extra_description";

    private String description;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);

        String categoryName = getArguments().getString(EXTRA_NAME); // Cara 1 mengambil data dari Bundle
        tvCategoryName.setText(categoryName);

        tvCategoryDescription.setText(getDescription()); // Cara 2 mengambil data dengan Getter

        btnShowDialog.setOnClickListener(v -> {
            FragmentManager mFragmentManager = getChildFragmentManager(); // Pada Fragment ini (Dialog) - Fragment Manager menggunakan ChildFragmentManager
            OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();

            mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
        });

        btnProfile.setOnClickListener(v -> {
            Intent mIntent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(mIntent);
        });
    }

    OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}