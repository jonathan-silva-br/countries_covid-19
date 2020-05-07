package com.example.treinamento.view;

import com.example.treinamento.R;
import com.example.treinamento.presenter.MainAcitivityPresenter;

public class MainActivity extends BaseActivity<MainAcitivityPresenter> implements MainAcitivityView {

    @Override
    protected void onViewReady() {
        super.onViewReady();
    }

    @Override
    int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    MainAcitivityPresenter getPresenter() {
        return new MainAcitivityPresenter(this);
    }
}
