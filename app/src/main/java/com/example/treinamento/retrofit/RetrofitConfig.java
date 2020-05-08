package com.example.treinamento.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public Retrofit retrofit;
    private final String BASE_URL = "https://api.covid19api.com";

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }



}
