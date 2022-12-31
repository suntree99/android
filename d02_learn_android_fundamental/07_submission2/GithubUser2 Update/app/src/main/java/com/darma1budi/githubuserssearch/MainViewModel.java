package com.darma1budi.githubuserssearch;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    private final MutableLiveData<List<ItemsItem>> _userList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _isError = new MutableLiveData<>();

    public LiveData<Boolean> isLoading() { return _isLoading; }
    public LiveData<List<ItemsItem>> userList() { return _userList; }
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

    public MainViewModel() {
        displayUserList();
    }

    public void displayUserList() {
//        _isLoading.setValue(true);

        Call<List<ItemsItem>> users = ApiConfig.getApiService().getUserList();
        users.enqueue(new Callback<List<ItemsItem>>() {
            @Override
            public void onResponse(Call<List<ItemsItem>> call, Response<List<ItemsItem>> response) {
                if (response.isSuccessful()) {
//                    _isLoading.setValue(false);
                    _userList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ItemsItem>> call, Throwable t) {
//                _isLoading.setValue(false);
                _isError.setValue(true);
            }
        });
    }

    public void setUserList(String username) {
//        _isLoading.setValue(true);

        Call<ItemsResponse> userSearchCall = ApiConfig.getApiService().getUserSearch(username);
        userSearchCall.enqueue(new Callback<ItemsResponse>() {
            @Override
            public void onResponse(@NotNull Call<ItemsResponse> call, @NotNull Response<ItemsResponse> response) {
                // showLoading(false);
                ItemsResponse responseBody = response.body();
                if (response.isSuccessful() && responseBody != null) {
                    _userList.postValue(responseBody.getItems());
//                    Log.d(TAG, "DATANYA : " + response.body().getItems());
                }
            }

            @Override
            public void onFailure(@NotNull Call<ItemsResponse> call, @NotNull Throwable t) {
                // showLoading(false);
                Log.e("ERROR", "onFailure: " + t.getMessage());
            }
        });
    }
}