package com.example.treinamento.presenter;

import com.example.treinamento.rules.BaseRules;
import com.example.treinamento.view.BaseView;


public abstract class BasePresenter<V extends BaseView, R extends BaseRules> {

    protected V view;
    protected R rules;

    public BasePresenter(V view, R rules) {
        this.view = view;
        this.rules = rules;
    }

    public abstract void onViewReady();


}
