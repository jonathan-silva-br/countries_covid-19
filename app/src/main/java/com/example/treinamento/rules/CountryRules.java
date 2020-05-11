package com.example.treinamento.rules;

import android.content.Context;
import com.example.treinamento.model.Country;
import com.example.treinamento.model.dao.room.AppDataBase;
import com.example.treinamento.model.dao.room.dao.CountryDao;
import com.example.treinamento.retrofit.CountryService;
import com.example.treinamento.retrofit.RetrofitConfig;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

public class CountryRules extends BaseRules<CountryDao> {

    public CountryRules(Context context) {
        super(AppDataBase.getInstance(context).countryDao());
    }

    public void insertIfNotExists(List<Country> countries){
        for (Country country: countries) {
            if (getDao().loadByName(country.getName()) == null){
                getDao().insert(country);
            }
        }
    }

    public List<Country> loadAll(){
        return getDao().loadAllOrderByName();
    }

    public void getCountries(Callback<List<Country>> callback){
        CountryService service = new RetrofitConfig().getRetrofit().create(CountryService.class);
        Call<List<Country>> call = service.getInfectedCountries();
        call.enqueue(callback);
    }

}
