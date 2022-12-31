package com.darma1budi.githubuser2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

interface ApiService {

    @GET("users")
    Call<List<ItemsItem>> getUserList();

    @GET("users/{user}")
    Call<ItemsItem> getUserDetail(
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

    @GET("search/users")
    Call<UserResponse> getUserSearch(
            @Query("q") String q
    );
}