package com.example.treinamento.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.treinamento.R;
import com.example.treinamento.model.Country;
import com.example.treinamento.view.holder.CountriesHolder;

import java.util.List;

public class CountriesAdapter extends AbstractAdapter<Country, CountriesHolder> {


    public CountriesAdapter(List<Country> itens) {
        super(itens);
    }

    @NonNull
    @Override
    public CountriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_countries, parent, false);
        return new CountriesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesHolder holder, int position) {
        holder.bind(itens.get(position));
    }
}
