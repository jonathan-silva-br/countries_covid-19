package com.example.treinamento.model.dao.room.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.treinamento.model.Country;

import java.util.List;

@Dao
public interface CountryDao {

    @Query("SELECT * FROM Country ORDER BY Country.name")
    List<Country> loadAllOrderByName();

    @Insert
    void insert(List<Country> countries);

    @Insert
    void insert(Country country);

    @Query("SELECT * FROM Country WHERE Country.name = :name")
    public Country loadByName(String name);

}
