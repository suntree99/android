package com.darma1budi.githubuserssearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.darma1budi.githubuserssearch.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;
    private final ArrayList<User> list = new ArrayList<>();
    //    private final ArrayList<ItemsItem> userList = new ArrayList<>();
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_DATA = "extra_data";
//    private final int[] TAB_TITLES = new int[] {
//            R.string.text_followers,
//            R.string.text_following,
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.rvUsers.setHasFixedSize(true);

//        list.addAll(getListUsers());
//        showRecyclerUserList();

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.userList().observe(this, this::showRecyclerUserList);
    }

//    public ArrayList<User> getListUsers() {
//        String[] dataName = getResources().getStringArray(R.array.name);
//        String[] dataUsername = getResources().getStringArray(R.array.username);
//        String[] dataCompany = getResources().getStringArray(R.array.company);
//        String[] dataLocation = getResources().getStringArray(R.array.location);
//        String[] dataRepository = getResources().getStringArray(R.array.repository);
//        String[] dataFollower = getResources().getStringArray(R.array.followers);
//        String[] dataFollowing = getResources().getStringArray(R.array.following);
//        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.avatar);
//
//        ArrayList<User> listUser = new ArrayList<>();
//
//        for (int i = 0; i < dataName.length; i++) {
//            User user = new User();
//            user.setName(dataName[i]);
//            user.setUsername(dataUsername[i]);
//            user.setCompany(dataCompany[i]);
//            user.setLocation(dataLocation[i]);
//            user.setRepository(dataRepository[i]);
//            user.setFollowers(dataFollower[i]);
//            user.setFollowing(dataFollowing[i]);
//            user.setAvatar(dataPhoto.getResourceId(i, -1));
//
//            listUser.add(user);
//        }
//
//        return listUser;
//    }

//    private void showRecyclerList(){
//
//        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            mainBinding.rvUsers.setLayoutManager(new GridLayoutManager(this, 2));
//        } else {
//            mainBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
//        }
//
//        UserAdapter userAdapter = new UserAdapter(list);
//        mainBinding.rvUsers.setAdapter(userAdapter);
//
//        userAdapter.setOnItemClickCallback(this::showDetailedUser);
//    }

    private void showRecyclerUserList(List<ItemsItem> userList) {

        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainBinding.rvUsers.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            mainBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        }

        UserListAdapter userListAdapter = new UserListAdapter(userList);
        mainBinding.rvUsers.setAdapter(userListAdapter);

//        userListAdapter.setOnItemClickCallback(new UserListAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(ItemsItem data) {
//                Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
//                intent.putExtra(EXTRA_DATA, (Serializable) data);
//                startActivity(intent);
//            }
//        });

        userListAdapter.setOnItemClickCallback(new UserListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(ItemsItem data) {
                Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
                intent.putExtra(EXTRA_DATA, data);
                startActivity(intent);
            }
        });

    }

//    private void showDetailedUser(User user) {
//        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//        intent.putExtra(DetailActivity.EXTRA_USER, user);
//        startActivity(intent);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btn_item_search) {
            SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);

            MenuItem searchItem = item;
            SearchView searchView = (SearchView) item.getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));

            searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem p0) {
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem p0) {
                    mainViewModel.displayUserList();
                    return true;
                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
//                    findUsers(query);
                    mainViewModel.setUserList(query);
                    searchView.clearFocus();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return true;
    }
}