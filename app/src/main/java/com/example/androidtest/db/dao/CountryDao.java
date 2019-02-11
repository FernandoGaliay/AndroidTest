package com.example.androidtest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.data.dbo.CountryNameWithFruit;
import com.example.androidtest.data.dbo.CountryWithFruit;

import java.util.List;

@Dao
public interface CountryDao {

    @Query("SELECT * FROM country_table")
    List<CountryWithFruit> getCountriesWithFruits();

    @Query("SELECT id, name, code FROM country_table")
    List<CountryNameWithFruit> getCountryNameWithFruits();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<CountryDbo> countryDboList);

    @Query("SELECT * FROM country_table")
    LiveData<List<CountryDbo>> getDataAsync();

    @Query("SELECT * FROM country_table")
    List<CountryDbo> getData();

    @Query("DELETE FROM country_table")
    void deleteAll();

    @Query(("SELECT id, name, code FROM country_table WHERE name LIKE :name"))
    List<CountryNameWithFruit> getCountryByName(String name);
}
