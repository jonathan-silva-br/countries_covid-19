package com.example.treinamento.presenter;

import com.example.treinamento.model.Country;
import com.example.treinamento.view.CountriesActivityView;
import com.example.treinamento.view.adapter.CountriesAdapter;

import java.util.ArrayList;
import java.util.List;

public class CountriesPresenter extends BasePresenter<CountriesActivityView> {


    public CountriesPresenter(CountriesActivityView view) {
        super(view);
    }

    @Override
    public void onViewReady() {
        List<Country> countries = loadAllCountries();
        CountriesAdapter adapter = new CountriesAdapter(countries);
        view.setAdapter(adapter);
    }

    private List<Country> loadAllCountries(){
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Brazil", "BR"));
        countries.add(new Country("Benin", "BJ"));
        countries.add(new Country("Jamaica", "JM"));
        countries.add(new Country("Belgium", "BE"));
        countries.add(new Country("Canada", "CA"));
        countries.add(new Country("Barbados", "BB"));
        countries.add(new Country("Egypt", "EG"));
        return countries;
    }
}
