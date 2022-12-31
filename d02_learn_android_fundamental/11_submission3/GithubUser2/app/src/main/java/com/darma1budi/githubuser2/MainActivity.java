package com.darma1budi.githubuser2;

import static androidx.datastore.preferences.PreferenceDataStoreDelegateKt.preferencesDataStore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.core.DataStore;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.darma1budi.githubuser2.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    private final DataStore<Preferences> dataStore = preferencesDataStore(name = "settings");
    private ActivityMainBinding mainBinding;
    private MainViewModel viewModel;
    private UserAdapter userAdapter;
    private RecyclerView listRecyclerView;
    public static final int[] TAB_TITLES = new int[] {
            R.string.text_followers,
            R.string.text_following,
    };
    public static final String EXTRA_DATA = "extra_data";

//    private static final String TAG = MainActivity.class.getSimpleName();
    private final ArrayList<User> list = new ArrayList<>();
//    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        PreferenceSetting pref = PreferenceSetting.getInstance(dataStore);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Github User's Search");
        }

        userAdapter = new UserAdapter();
        userAdapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemCLicked(ItemsItem data) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_USER, data.getLogin());
                startActivity(intent);
            }
        });

        PersonListViewModelFactory searchViewModelFactory = new PersonListViewModelFactory(this.getApplication(), "", pref);
        listViewModel = ViewModelProvider.of(this, searchViewModelFactory).get(PersonListViewModel.class);

        mainBinding.rvUsers.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainBinding.rvUsers.setHasFixedSize(true);
        mainBinding.rvUsers.setAdapter(userAdapter);

        mainBinding.iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchUser();
            }
        });

        mainBinding.inputLayout.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    searchUser();
                    return true;
                }
                return false;
            }
        });

        viewModel.userList().observe(this, this::showRecyclerList);
        viewModel.isLoading().observe(this, this::showLoading);
        viewModel.isError.observe(this, aBoolean -> {
            Toast.makeText(this, "Tidak ada data!", Toast.LENGTH_SHORT).show();
            viewModel.doneToastErrorInput();
        });

//        viewModel.getIsDarkMode().observe(this, aBoolean -> {
//            if (aBoolean) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//            }
//        });

        listRecyclerView = mainBinding.rvUsers;
        listRecyclerView.setHasFixedSize(true);

        list.addAll(getListUsers());
        showRecyclerList();
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
            mainBinding.rvUsers.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            mainBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        }

        ListUserAdapter listUserAdapter = new ListUserAdapter(list);
        mainBinding.rvUsers.setAdapter(listUserAdapter);

        listUserAdapter.setOnItemClickCallback(this::showDetailedUser);
    }

    private void showRecyclerList(List<ItemsItem> userList) {
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter personListAdapter = new UserListAdapter(userList);
        listRecyclerView.setAdapter(personListAdapter);

        personListAdapter.setOnItemClickCallback(new UserListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(ItemsItem data) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(EXTRA_DATA, (Serializable) data);
                startActivity(intent);
            }
        });
    }

    private void showDetailedUser(User user) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_USER, user);
        startActivity(intent);
    }

    private void searchUser() {
        showLoading(true);
        String query = mainBinding.inputLayout.getEditText().toString();
        if (!query.isEmpty()) {
            showLoading(false);
            viewModel.setUserList(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btn_search) {
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
                    viewModel.displayUserList();
                    return true;
                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
//                    findUser(query);
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

    private void showLoading(Boolean isLoading) {
        if (isLoading) {
            mainBinding.progressBar.setVisibility(View.VISIBLE);
        } else {
            mainBinding.progressBar.setVisibility(View.GONE);
        }
    }

    //    private void findUser(String query) {
////        showLoading(true);
//
//        Call<SearchResponse> search = ApiConfig.getApiService().searchUsers(query);
//        search.enqueue(new Callback<SearchResponse>() {
//
//            @Override
//            public void onResponse(@NotNull Call<SearchResponse> call, @NotNull Response<SearchResponse> response) {
////                showLoading(false);
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        Log.d(TAG, "DATANYA : " + response.body().getItems());
//                        ArrayList<ItemsItem> listData = (ArrayList<ItemsItem>) response.body().getItems();
//                    }
//                } else {
//                    if (response.body() != null) {
//                        Log.e(TAG, "onFailure: " + response.body().getTotalCount());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<SearchResponse> call, @NotNull Throwable t) {
////                showLoading(false);
//                Log.e(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//    }
}