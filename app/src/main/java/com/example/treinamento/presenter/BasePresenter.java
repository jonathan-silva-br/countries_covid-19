package com.example.treinamento.presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.treinamento.view.BaseView;


public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    public abstract void onViewReady();


}
