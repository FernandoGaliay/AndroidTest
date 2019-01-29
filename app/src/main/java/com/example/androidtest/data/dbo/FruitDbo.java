package com.example.androidtest.data.dbo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "fruit_table")
public class FruitDbo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item")
    private String item;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "farm_name")
    private String farmName;

    @ColumnInfo(name = "phone")
    private String phone;

    public FruitDbo(@NonNull String item, String category, String farmName, String phone) {
        this.item = item;
        this.category = category;
        this.farmName = farmName;
        this.phone = phone;
    }

    @NonNull
    public String getItem() {
        return item;
    }

    public String getCategory() {
        return category;
    }

    public String getFarmName() {
        return farmName;
    }

    public String getPhone() {
        return phone;
    }
}
