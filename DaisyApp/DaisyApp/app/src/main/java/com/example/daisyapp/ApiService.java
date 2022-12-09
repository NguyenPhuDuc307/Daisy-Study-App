package com.example.daisyapp;

import com.example.daisyapp.Models.LoginRequest;
import com.example.daisyapp.Models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    //khởi tạo Gson
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //khởi tạo Service
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://www.ssdaisy.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("api/users/login")
    Call<User> Login(@Body LoginRequest request);

    @GET("api/users/getall")
    Call<List<User>> GetAll();
}
