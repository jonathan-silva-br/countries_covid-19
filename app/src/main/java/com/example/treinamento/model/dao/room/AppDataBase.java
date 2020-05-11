package com.example.treinamento.model.dao.room;

import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.treinamento.model.Country;
import com.example.treinamento.model.dao.room.dao.CountryDao;

@Database(version = 1, entities = {Country.class})
public abstract class AppDataBase extends RoomDatabase {


    private static final String DATABASE_NAME = "database_treinamento";
    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,  DATABASE_NAME)
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTANCE;
    }

    public abstract CountryDao countryDao();

    //Define o que será feito em casa de atualização da versão
    static final Migration MIGRATION_1_2 = new Migration(1,2){
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

}
