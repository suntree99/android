package com.darma1budi.githubuserssearch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    private final MutableLiveData<ItemsDetails> _userDetail = new MutableLiveData<>();
    private final MutableLiveData<List<ItemsItem>> _followList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _isError = new MutableLiveData<>();

    public LiveData<Boolean> isLoading() { return _isLoading; }
    public LiveData<ItemsDetails> userDetail() { return _userDetail; }
    public LiveData<List<ItemsItem>> followList() { return _followList; }
    public LiveData<Boolean> isError = _isError;

    private static final String TAG = MainActivity.class.getSimpleName();

//    LiveData<Boolean> isDarkMode = pref.getThemeSetting().asLiveData();

//    public void doneToastErrorInput() { _isError.setValue(false); }
//    public Boolean checkDarkMode() { return isDarkMode.getValue(); }
//    public void saveThemeSetting(boolean isDarkModeActive) {
//        viewModelScope.launch(() -> {
//            pref.saveThemeSetting(isDarkModeActive);
//        });
//    }

//    public UserDetailViewModel() {
//        displayUserDetail();
//    }

    public void displayUserDetail(String username) {
//        _isLoading.setValue(true);

        Call<ItemsDetails> userDetail = ApiConfig.getApiService().getUserDetail(username);
        userDetail.enqueue(new Callback<ItemsDetails>() {
            @Override
            public void onResponse(Call<ItemsDetails> call, Response<ItemsDetails> response) {
                if (response.isSuccessful()) {
//                    _isLoading.setValue(false);
                    _userDetail.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemsDetails> call, Throwable t) {
//                _isLoading.setValue(false);
                _isError.setValue(true);
            }
        });
    }

    public void displayFollowerList(String username) {
//        _isLoading.setValue(true);

        Call<List<ItemsItem>> followers = ApiConfig.getApiService().getUserFollowers(username);
        followers.enqueue(new Callback<List<ItemsItem>>() {
            @Override
            public void onResponse(Call<List<ItemsItem>> call, Response<List<ItemsItem>> response) {
                if (response.isSuccessful()) {
//                    _isLoading.setValue(false);
                    _followList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ItemsItem>> call, Throwable t) {
//                _isLoading.setValue(false);
                _isError.setValue(true);
            }
        });
    }

    public void displayFollowingList(String username) {
//        _isLoading.setValue(true);

        Call<List<ItemsItem>> followers = ApiConfig.getApiService().getUserFollowing(username);
        followers.enqueue(new Callback<List<ItemsItem>>() {
            @Override
            public void onResponse(Call<List<ItemsItem>> call, Response<List<ItemsItem>> response) {
                if (response.isSuccessful()) {
//                    _isLoading.setValue(false);
                    _followList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ItemsItem>> call, Throwable t) {
//                _isLoading.setValue(false);
                _isError.setValue(true);
            }
        });
    }

    public void doneToastErrorInput() {
        _isError.setValue(false);
    }
}