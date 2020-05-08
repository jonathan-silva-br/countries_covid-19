package com.example.treinamento.retrofit;

import com.example.treinamento.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryService {

    @GET("/countries")
    Call<List<Country>> getInfectedCountries();
}
