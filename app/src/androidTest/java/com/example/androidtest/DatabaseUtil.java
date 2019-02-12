package com.example.androidtest;

import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.data.dbo.CountryUtil;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.dbo.LocationDbo;
import com.example.androidtest.db.dao.CountryDao;
import com.example.androidtest.db.dao.FruitDao;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    public static void populateCountryTable(CountryDao countryDao) {
        countryDao.insert(CountryUtil.getCountries());
    }


    public static void populateFruitTable(FruitDao fruitDao, CountryDao countryDao) {
        List<CountryDbo> countryDaoList = countryDao.getData();
        FruitDbo apple = new FruitDbo("1", "Apple", "Apple Category", "Apple farm", "666666666", LocationDbo.getDefaultInstance(), countryDaoList.get(0).getId());
        FruitDbo orange = new FruitDbo("2", "Orange", "Orange Category", "Orange farm", "666666667", LocationDbo.getDefaultInstance(), countryDaoList.get(1).getId());
        FruitDbo banana = new FruitDbo("3", "Banana", "Banana Category", "Banana farm", "666666666", LocationDbo.getDefaultInstance(), countryDaoList.get(0).getId());
        List<FruitDbo> fruitDboList = new ArrayList<>();
        fruitDboList.add(apple);
        fruitDboList.add(orange);
        fruitDboList.add(banana);
        fruitDao.insert(fruitDboList);
    }

}
