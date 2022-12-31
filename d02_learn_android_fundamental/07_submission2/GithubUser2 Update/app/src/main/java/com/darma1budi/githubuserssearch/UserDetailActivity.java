package com.darma1budi.githubuserssearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.darma1budi.githubuserssearch.databinding.ActivityUserDetailBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class UserDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityUserDetailBinding userDetailBinding;
    private UserDetailViewModel userDetailViewModel;
//    public static final String EXTRA_USER = "extra_user";
    private final int[] TAB_TITLES = new int[] {
            R.string.text_followers,
            R.string.text_following,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDetailBinding = ActivityUserDetailBinding.inflate(getLayoutInflater());
        setContentView(userDetailBinding.getRoot());

        ItemsItem user = getIntent().getParcelableExtra(MainActivity.EXTRA_DATA);
        String username = user.getLogin();

        userDetailViewModel = new ViewModelProvider(this).get(UserDetailViewModel.class);
        userDetailViewModel.displayUserDetail(username);

        // link viewpager with tab layout
        SectionPagerAdapter sectionsPagerAdapter = new SectionPagerAdapter(this);
        ViewPager2 viewPager = userDetailBinding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = userDetailBinding.tabs;
        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            tab.setText(getResources().getString(TAB_TITLES[position]));
        }).attach();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }

        userDetailViewModel.userDetail().observe(this, userDetail -> {
//            showLoading(false);
            userDetailBinding.tvItemName.setText(userDetail.getName());
            userDetailBinding.tvItemUsername.setText(userDetail.getLogin());
            userDetailBinding.tvItemCompany.setText(userDetail.getCompany());
            userDetailBinding.tvItemLocation.setText(userDetail.getLocation());
            userDetailBinding.tvDataRepositories.setText(String.valueOf(userDetail.getPublicRepos()));
            userDetailBinding.tvDataFollowers.setText(String.valueOf(userDetail.getFollowers()));
            userDetailBinding.tvDataFollowing.setText(String.valueOf(userDetail.getFollowing()));
            Glide.with(this)
                    .load(userDetail.getAvatarUrl())
                    .circleCrop()
                    .into(userDetailBinding.imgItemAvatar);

            userDetailBinding.btnItemShare.setOnClickListener(view -> {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        userDetail.getName().toUpperCase() + "\n\n" +
                                "Username : " + userDetail.getLogin() + "\n" +
                                "Company : " + userDetail.getCompany() + "\n" +
                                "Location : " + userDetail.getLocation() + "\n" +
                                "Repository : " + userDetail.getPublicRepos() + "\n" +
                                "Followers : " + userDetail.getFollowers() + "\n" +
                                "Following : " + userDetail.getFollowing()
                );
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            });
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail User");
        }
    }

    @Override
    public void onClick(View view) {

    }
}