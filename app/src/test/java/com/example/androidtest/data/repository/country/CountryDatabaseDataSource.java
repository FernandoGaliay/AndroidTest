package com.example.androidtest.data.repository.country;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.data.dbo.CountryDbo;

import java.util.ArrayList;
import java.util.List;

public class CountryDatabaseDataSource {

    public LiveData<List<CountryDbo>> getCountryies() {
        CountryDbo countryDbo = new CountryDbo();
        countryDbo.setId(1);
        countryDbo.setCode("ES");
        countryDbo.setName("SPAIN");
        List<CountryDbo> countryDboList = new ArrayList<>();
        countryDboList.add(countryDbo);
        MutableLiveData<List<CountryDbo>> listMutableLiveData = new MutableLiveData<>();
        listMutableLiveData.setValue(countryDboList);
        return listMutableLiveData;
    }


    public LiveData<List<CountryDbo>> getDataAsync() {
        return getCountryies();
    }
}
