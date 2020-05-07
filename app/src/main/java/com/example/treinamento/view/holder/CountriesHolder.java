package com.example.treinamento.view.holder;

import android.view.View;
import android.widget.TextView;

import com.example.treinamento.R;
import com.example.treinamento.model.Country;

import butterknife.BindView;

public class CountriesHolder extends AbstractHolder<Country> {

    @BindView(R.id.row_recyclerView_countries_textview_country)
    TextView textViewCountry;

    @BindView(R.id.row_recyclerView_countries_iso2)
    TextView textViewiso2;

    public CountriesHolder(View view) {
        super(view);
    }

    @Override
    public void bind(Country object) {
        textViewCountry.setText(object.getName());
        textViewiso2.setText(object.getIso2());

    }
}
