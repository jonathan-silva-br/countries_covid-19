package com.example.treinamento.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treinamento.R;
import com.example.treinamento.presenter.CountriesPresenter;
import com.example.treinamento.view.adapter.AbstractAdapter;

import butterknife.BindView;

public class CountriesActivity extends BaseActivity<CountriesPresenter> implements CountriesActivityView{

    @BindView(R.id.activity_countries_recyclerview)
    RecyclerView recyclerViewCountries;

    @Override
    int getLayoutView() {
        return R.layout.activity_countries;
    }

    @Override
    CountriesPresenter getPresenter() {
        return new CountriesPresenter(this);
    }


    @Override
    public <A extends AbstractAdapter> void setAdapter(A adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCountries.setLayoutManager(layoutManager);
        recyclerViewCountries.setAdapter(adapter);
    }
}
