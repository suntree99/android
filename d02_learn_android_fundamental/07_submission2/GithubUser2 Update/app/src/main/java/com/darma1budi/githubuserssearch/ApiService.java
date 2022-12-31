package com.darma1budi.githubuserssearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

interface ApiService {

    @GET("users")
    Call<List<ItemsItem>> getUserList();

    @GET("search/users")
    Call<ItemsResponse> getUserSearch(
            @Query("q") String q
    );

    @GET("users/{user}")
    Call<ItemsDetails> getUserDetail(
            @Path("user") String user
    );

    @GET("users/{user}/followers")
    Call<List<ItemsItem>> getUserFollowers(
            @Path("user") String user
    );

    @GET("users/{user}/following")
    Call<List<ItemsItem>> getUserFollowing(
            @Path("user") String user
    );

}