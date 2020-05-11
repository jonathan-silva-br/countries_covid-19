package com.example.treinamento.presenter;

import android.content.Context;
import android.widget.Toast;
import com.example.treinamento.model.Country;
import com.example.treinamento.rules.CountryRules;
import com.example.treinamento.utils.Util;
import com.example.treinamento.view.CountriesActivityView;
import com.example.treinamento.view.adapter.CountriesAdapter;
import java.net.HttpURLConnection;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesPresenter extends BasePresenter<CountriesActivityView, CountryRules> implements Callback<List<Country>> {

    public CountriesPresenter(CountriesActivityView view) {
        super(view, new CountryRules((Context)view));
    }

    @Override
    public void onViewReady() {
        if (Util.isOnline((Context) view)){
            view.showLoading();
            rules.getCountries(this);
        }else{
            loadCountries();
        }
    }

    private void loadCountries(){
        List<Country> countries = rules.loadAll();
        CountriesAdapter adapter = new CountriesAdapter(countries);
        view.setAdapter(adapter);
    }

    @Override
    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        view.hideLoading();

        if(response.raw().code() == HttpURLConnection.HTTP_OK && response.body() != null){
            rules.insertIfNotExists(response.body());
            loadCountries();
        }else{
            Toast.makeText((Context) view, "Falha ao atualizar informações", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<List<Country>> call, Throwable t) {
        Toast.makeText((Context) view, "Falha ao atualizar informações", Toast.LENGTH_LONG).show();
    }
}
