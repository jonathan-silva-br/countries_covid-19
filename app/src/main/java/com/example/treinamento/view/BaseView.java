package com.example.treinamento.view;

import com.example.treinamento.view.adapter.AbstractAdapter;

public interface BaseView {

    <A extends AbstractAdapter> void setAdapter(A adapter);



}
