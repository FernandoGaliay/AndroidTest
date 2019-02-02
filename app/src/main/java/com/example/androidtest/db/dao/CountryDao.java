package com.example.androidtest.db.dao;

import android.arch.persistence.room.Query;

import com.example.androidtest.data.dbo.CountryNameWithFruit;
import com.example.androidtest.data.dbo.CountryWithFruit;

import java.util.List;

public interface CountryDao {

    @Query("SELECT * FROM country_table")
    List<CountryWithFruit> getCountriesWithFruits();

    @Query("SELECT * FROM country_table")
    List<CountryNameWithFruit> getCountryNameWithFruits();

}
