package com.example.androidtest.data.dbo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class CountryWithFruit {

    @Embedded
    private CountryDbo countryDbo;

    @Relation(parentColumn = "id", entityColumn = "country_id", entity = FruitDbo.class)
    private List<FruitDbo> fruitDboList;

    public CountryDbo getCountryDbo() {
        return countryDbo;
    }

    public List<FruitDbo> getFruitDboList() {
        return fruitDboList;
    }

    public void setCountryDbo(CountryDbo countryDbo) {
        this.countryDbo = countryDbo;
    }

    public void setFruitDboList(List<FruitDbo> fruitDboList) {
        this.fruitDboList = fruitDboList;
    }
}
