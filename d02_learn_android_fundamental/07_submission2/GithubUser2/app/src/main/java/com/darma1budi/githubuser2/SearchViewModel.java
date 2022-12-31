package com.darma1budi.githubuser2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {
    private MutableLiveData<List<ItemsItem>> searchListUser = new MutableLiveData<>();

    public void setTheUserSearch(String username) {
        Call<SearchResponse> clientHunter = ApiConfig.getApiService().getUserSearch(username);
        clientHunter.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                SearchResponse responseBody = response.body();
                if (response.isSuccessful() && responseBody != null) {
                    searchListUser.postValue(responseBody.getItems());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.e("ERROR", "onFailure: " + t.getMessage());
            }
        });
    }

    public LiveData<List<ItemsItem>> getTheUserSearch() {
        return searchListUser;
    }
}
