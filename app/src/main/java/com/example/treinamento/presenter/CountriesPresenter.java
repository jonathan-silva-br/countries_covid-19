package com.example.treinamento.presenter;

import android.content.Context;

import com.example.treinamento.model.Country;
import com.example.treinamento.model.dao.CountryDao;
import com.example.treinamento.retrofit.CountryService;
import com.example.treinamento.retrofit.RetrofitConfig;
import com.example.treinamento.view.CountriesActivityView;
import com.example.treinamento.view.adapter.CountriesAdapter;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CountriesPresenter extends BasePresenter<CountriesActivityView> {


    public CountriesPresenter(CountriesActivityView view) {
        super(view);
    }

    @Override
    public void onViewReady() {
        List<Country> countries = loadAllCountries();
        CountriesAdapter adapter = new CountriesAdapter(countries);
        view.setAdapter(adapter);

        CountryService service = new RetrofitConfig().getRetrofit().create(CountryService.class);

        Call<List<Country>> call = service.getInfectedCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if(response.raw().code() == HttpURLConnection.HTTP_OK && response.body() != null){
                    CountryDao countryDao = new CountryDao((Context) view);
                    countryDao.insertIfNotExists(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }

    private List<Country> loadAllCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Brazil", "brazil", "BR"));
        countries.add(new Country("Canada", "canada", "CA"));
        countries.add(new Country("Qatar", "qtar", "QA"));
        countries.add(new Country("India", "india", "IN"));
        countries.add(new Country("Sudan", "sudan", "SD"));
        countries.add(new Country("Madasgascar", "madagascar", "MG"));
        return countries;
    }
}
