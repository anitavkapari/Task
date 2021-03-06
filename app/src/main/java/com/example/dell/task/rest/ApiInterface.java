package com.example.dell.task.rest;

import com.example.dell.task.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("users")
    public Call<List<Users>> getUsers();
}
