package com.example.treinamento.rules;

public abstract class BaseRules<T>{

    protected  T dao;

    public BaseRules(T dao){
        this.dao = dao;
    }

    public T getDao(){
        return dao;
    }
}
