package com.darma1budi.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = findViewById(R.id.tv_item_name);
        TextView tvUsername = findViewById(R.id.tv_item_username);
        TextView tvCompany = findViewById(R.id.tv_item_company);
        TextView tvLocation = findViewById(R.id.tv_item_location);
        TextView tvRepository = findViewById(R.id.tv_item_repository);
        TextView tvFollower = findViewById(R.id.tv_item_follower);
        TextView tvFollowing = findViewById(R.id.tv_item_following);
        ImageView ivAvatar = findViewById(R.id.img_item_avatar);

        Button btnActionShare = findViewById(R.id.btn_share);

        User user = getIntent().getParcelableExtra(EXTRA_USER);
        tvName.setText(user.getName());
        tvUsername.setText(user.getUsername());
        tvCompany.setText(user.getCompany());
        tvLocation.setText(user.getLocation());
        String textRepository = "Repository : " + user.getRepository();
        tvRepository.setText(textRepository);
        String textFollowers = "Followers : " + user.getFollowers();
        tvFollower.setText(textFollowers);
        String textFollowing = "Following : " + user.getFollowing();
        tvFollowing.setText(textFollowing);
        Glide.with(ivAvatar)
                .load(user.getAvatar())
                .circleCrop()
                .into(ivAvatar);

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