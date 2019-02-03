package com.example.androidtest.data.repository.country;

import android.arch.lifecycle.LiveData;

import com.example.androidtest.TestApplication;
import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.db.TestRoomDatabase;
import com.example.androidtest.db.dao.CountryDao;

import java.util.List;

public class CountryDatabaseDataSource {

    private CountryDao countryDao;

    public CountryDatabaseDataSource() {

        TestRoomDatabase db = TestRoomDatabase.getDatabase(TestApplication.getINSTANCE());
        countryDao = db.countryDao();

    }

    public void setData(List<CountryDbo> countryDboList){

        countryDao.insert(countryDboList);

    }

    public void setDataAsync(List<CountryDbo> countryDboList) {

        new Thread() {

            @Override
            public void run() {

                countryDao.insert(countryDboList);

            }

        }.start();

    }

    public LiveData<List<CountryDbo>> getDataAsync() {

        return countryDao.getDataAsync();

    }
}
