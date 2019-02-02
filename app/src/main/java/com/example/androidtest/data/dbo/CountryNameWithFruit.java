package com.example.androidtest.data.dbo;

import android.arch.persistence.room.Relation;

import java.util.List;

public class CountryNameWithFruit {

    private String id;

    private String name;

    @Relation(parentColumn = "id", entityColumn = "country_id")
    private List<FruitDbo> fruitDboList;
}
