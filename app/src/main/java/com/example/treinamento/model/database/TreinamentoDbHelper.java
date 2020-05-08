package com.example.treinamento.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.treinamento.model.dao.CountryDao;

public class TreinamentoDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DB_TREINAMENTO";
    private static final int DATABASE_VERSION = 1;

    public TreinamentoDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CountryDao.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(CountryDao.SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
