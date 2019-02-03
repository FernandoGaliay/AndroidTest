package com.example.androidtest.data.dbo;

import android.arch.persistence.room.Relation;

import java.util.List;

public class CountryNameWithFruit {

    private int id;

    private String name;

    private String code;

    @Relation(parentColumn = "id", entityColumn = "country_id")
    private List<FruitDbo> fruitDboList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FruitDbo> getFruitDboList() {
        return fruitDboList;
    }

    public void setFruitDboList(List<FruitDbo> fruitDboList) {
        this.fruitDboList = fruitDboList;
    }
}
