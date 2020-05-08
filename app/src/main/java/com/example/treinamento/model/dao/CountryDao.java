package com.example.treinamento.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.treinamento.model.Country;
import com.example.treinamento.model.database.TreinamentoDbHelper;

import java.util.List;

public class CountryDao {

    private TreinamentoDbHelper treinamentoDbHelper;
    private static final String TABLE_NAME = "Country";
    private static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_SLUG = "slug";
    private static final String COLUMN_NAME_ISO2 = "iso2";

    public CountryDao(Context context){
        this.treinamentoDbHelper = new TreinamentoDbHelper(context);
    }

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_NAME + " TEXT, " +
                    COLUMN_NAME_SLUG + " TEXT, " +
                    COLUMN_NAME_ISO2 + " TEXT)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String QUERY_SELECT_BY_NAME = "SELECT "
            + COLUMN_NAME_NAME + ","
            + COLUMN_NAME_SLUG + ","
            + COLUMN_NAME_ISO2
            + " FROM " + TABLE_NAME
            + " WHERE " + COLUMN_NAME_NAME + " = ?";


    public void insert(Country country){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NAME, country.getName());
        values.put(COLUMN_NAME_SLUG, country.getSlug());
        values.put(COLUMN_NAME_ISO2, country.getIso2());

        treinamentoDbHelper.getWritableDatabase().insert(TABLE_NAME, null, values);
    }

    public void insertIfNotExists(List<Country> countries){
        for (Country country:countries) {
            this.insertIfNotExists(country);
        }
    }

    public void insertIfNotExists(Country country){

        String[] columns = new String[]{COLUMN_NAME_NAME, COLUMN_NAME_SLUG, COLUMN_NAME_ISO2};
        String[] params = new String[]{country.getName()};
        String selection = COLUMN_NAME_NAME + " = ?";
        Cursor cursor = null;
        try {
            cursor = treinamentoDbHelper.getReadableDatabase().query(TABLE_NAME, columns, selection, params, null, null, null);
            if(cursor.moveToFirst()){
                return;
            }
            insert(country);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null){
                cursor.close();
            }
        }



    }


}
