package com.example.androidtest.data.repository.country;

import android.arch.lifecycle.LiveData;

import com.example.androidtest.data.dbo.CountryDbo;

import java.util.List;

public class CountryRepository {

    private CountryDatabaseDataSource countryDatabaseDataSource;

    public CountryRepository() {

        countryDatabaseDataSource = new CountryDatabaseDataSource();

    }

    public void setData(List<CountryDbo> countryDboList) {

        countryDatabaseDataSource.setDataAsync(countryDboList);

    }


    public LiveData<List<CountryDbo>> getCountryies(){

        return countryDatabaseDataSource.getDataAsync();

    }

}
