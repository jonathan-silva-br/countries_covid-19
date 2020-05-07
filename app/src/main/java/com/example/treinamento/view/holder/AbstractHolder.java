package com.example.treinamento.view.holder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.ButterKnife;

abstract class AbstractHolder<T> extends RecyclerView.ViewHolder{

    protected T object;

    public AbstractHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public abstract void bind(T object);
}
