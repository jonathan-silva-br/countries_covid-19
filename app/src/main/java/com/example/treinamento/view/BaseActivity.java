package com.example.treinamento.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import com.example.treinamento.presenter.BasePresenter;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        ButterKnife.bind(this);
        presenter = getPresenter();
        onViewReady();
    }

    protected void onViewReady() {
        presenter.onViewReady();
    }

    abstract int getLayoutView();

    abstract P getPresenter();


}
