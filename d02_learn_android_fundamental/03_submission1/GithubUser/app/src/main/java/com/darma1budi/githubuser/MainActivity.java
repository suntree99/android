package com.darma1budi.githubuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUsers;
    private final ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUsers = findViewById(R.id.rv_users);
        rvUsers.setHasFixedSize(true);

        list.addAll(getListUsers());
        showRecyclerList();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Github User's");
        }
    }

    public ArrayList<User> getListUsers() {
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataUsername = getResources().getStringArray(R.array.username);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataLocation = getResources().getStringArray(R.array.location);
        String[] dataRepository = getResources().getStringArray(R.array.repository);
        String[] dataFollower = getResources().getStringArray(R.array.followers);
        String[] dataFollowing = getResources().getStringArray(R.array.following);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.avatar);

        ArrayList<User> listUser = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            User user = new User();
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            user.setCompany(dataCompany[i]);
            user.setLocation(dataLocation[i]);
            user.setRepository(dataRepository[i]);
            user.setFollowers(dataFollower[i]);
            user.setFollowing(dataFollowing[i]);
            user.setAvatar(dataPhoto.getResourceId(i, -1));

            listUser.add(user);
        }

        return listUser;
    }

    private void showRecyclerList(){

        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvUsers.setLayoutManager(new LinearLayoutManager(this));
        }

        ListUserAdapter listUserAdapter = new ListUserAdapter(list);
        rvUsers.setAdapter(listUserAdapter);

        listUserAdapter.setOnItemClickCallback(data -> showDetailedUser(data));
    }

    private void showDetailedUser(User user) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_USER, user);
        startActivity(intent);
    }

}