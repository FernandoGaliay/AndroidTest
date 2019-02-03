package com.example.androidtest.data.dbo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "country_table")
public class CountryDbo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "code")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public static CountryDbo getDefaultInstance() {

        CountryDbo defaultCountry = new CountryDbo();
        defaultCountry.setName("SPAIN");
        defaultCountry.setCode("ES");
        return defaultCountry;

    }

}
