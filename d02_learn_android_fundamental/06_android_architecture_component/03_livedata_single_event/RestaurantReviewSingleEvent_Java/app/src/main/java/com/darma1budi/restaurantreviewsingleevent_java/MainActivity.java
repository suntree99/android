package com.darma1budi.restaurantreviewsingleevent_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bumptech.glide.Glide;
import com.darma1budi.restaurantreviewsingleevent_java.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvReview.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        binding.rvReview.addItemDecoration(itemDecoration);

        MainViewModel mainViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        // Observer
        mainViewModel.getRestaurant().observe(this, restaurant -> {
            setRestaurantData(restaurant);
        });
        mainViewModel.getListReview().observe(this, consumerReviews -> {
            setReviewData(consumerReviews);
        });
        mainViewModel.isLoading().observe(this, isLoading -> {
            showLoading(isLoading);
        });

        // Pemanggilan snackbar yang menggunakan Event
        mainViewModel.snackbarText().observe(this, text -> {
            String snackBarText = text.getContentIfNotHandled();
            if (snackBarText != null) {
                Snackbar.make(
                    getWindow().getDecorView().getRootView(),
                    snackBarText,
                    Snackbar.LENGTH_SHORT
                ).show();
            }
        });

        binding.btnSend.setOnClickListener(view -> {
            mainViewModel.postReview(binding.edReview.getText().toString());

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        });
    }

    private void setRestaurantData(Restaurant restaurant) {
        binding.tvTitle.setText(restaurant.getName());
        binding.tvDescription.setText(restaurant.getDescription());

        Glide.with(MainActivity.this).
                load("https://restaurant-api.dicoding.dev/images/large/" + restaurant.getPictureId())
                .into(binding.ivPicture);
    }

    private void setReviewData(java.util.List<CustomerReviewsItem> consumerReviews) {
        ArrayList<String> listReview = new ArrayList<>();

        for (CustomerReviewsItem review : consumerReviews) {
            listReview.add(review.getReview() + "\n- " + review.getName());
        }

        ReviewAdapter adapter = new ReviewAdapter(listReview);
        binding.rvReview.setAdapter(adapter);
        binding.edReview.setText("");
    }

    private void showLoading(Boolean isLoading) {
        if (isLoading) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }
}