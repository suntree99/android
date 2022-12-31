package com.darma1budi.githubuser2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.darma1budi.githubuser2.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";
    private ActivityDetailBinding detailBinding;
//    private PersonDetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());

        Button btnActionShare = findViewById(R.id.btn_share);

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        detailBinding.tvItemName.setText(user.getName());
        detailBinding.tvItemUsername.setText(user.getUsername());
        detailBinding.tvItemCompany.setText(user.getCompany());
        detailBinding.tvItemLocation.setText(user.getLocation());
        String textRepository = "Repository : " + user.getRepository();
        detailBinding.tvItemRepository.setText(textRepository);
        String textFollowers = "Followers : " + user.getFollowers();
        detailBinding.tvItemFollower.setText(textFollowers);
        String textFollowing = "Following : " + user.getFollowing();
        detailBinding.tvItemFollowing.setText(textFollowing);
        Glide.with(detailBinding.imgItemAvatar)
                .load(user.getAvatar())
                .circleCrop()
                .into(detailBinding.imgItemAvatar);

        btnActionShare.setOnClickListener(view -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    user.getName().toUpperCase() + "\n\n" +
                            "Username : " + user.getUsername() + "\n" +
                            "Company : " + user.getCompany() + "\n" +
                            "Location : " + user.getLocation() + "\n" +
                            "Repository : " + user.getRepository() + "\n" +
                            "Followers : " + user.getFollowers() + "\n" +
                            "Following : " + user.getFollowing()
            );
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail User");
        }
    }
}