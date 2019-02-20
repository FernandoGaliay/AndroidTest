package com.example.androidtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.androidtest.data.dbo.CountryNameWithFruit;
import com.example.androidtest.data.dbo.CountryWithFruit;
import com.example.androidtest.data.repository.country.CountryRepository;
import com.example.androidtest.data.repository.fruit.FruitRepository;
import com.example.androidtest.db.TestRoomDatabase;
import com.example.androidtest.db.dao.CountryDao;
import com.example.androidtest.db.dao.FruitDao;
import com.example.androidtest.db.dao.FruitItemWithCountryName;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private CountryDao countryDao;

    private FruitDao fruitDao;

    private TestRoomDatabase testRoomDatabase;

    private FruitRepository fruitRepository;

    private CountryRepository countryRepository;

    @Before
    public void prepare() {
        Context context = InstrumentationRegistry.getContext();
        testRoomDatabase = Room.inMemoryDatabaseBuilder(context, TestRoomDatabase.class).build();
        countryDao = testRoomDatabase.countryDao();
        fruitDao = testRoomDatabase.fruitDao();
        fruitRepository = new FruitRepository();
        countryRepository = new CountryRepository();
        DatabaseUtil.populateCountryTable(countryDao);
        DatabaseUtil.populateFruitTable(fruitDao, countryDao);
    }

    @After
    public void finish() {
        testRoomDatabase.close();
    }

    @Test
    public void countryQueries() {
        List<CountryNameWithFruit> countryNameWithFruitList = countryDao.getCountryNameWithFruits();
        assert (countryNameWithFruitList != null && !countryNameWithFruitList.isEmpty());
        List<CountryWithFruit> countryWithFruitList = countryDao.getCountriesWithFruits();
        assert (countryWithFruitList != null && !countryWithFruitList.isEmpty());
    }

    @Test
    public void fruitQueries() {
        List<FruitItemWithCountryName> fruitItemWithCountryNames = fruitDao.getFruitWithCountryName();
        assert (fruitItemWithCountryNames != null && !fruitItemWithCountryNames.isEmpty());
    }

    @Test
    public void likeQueries() {
        String spainName = "SPAIN";
        String queryName = "%" + spainName + "%";
        List<CountryNameWithFruit> countryNameWithFruitList = countryDao.getCountryByName(queryName);
        assert (!countryNameWithFruitList.isEmpty() && spainName.equals(countryNameWithFruitList.get(0).getName()));
    }

}
