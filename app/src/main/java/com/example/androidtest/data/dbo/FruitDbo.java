package com.example.androidtest.data.dbo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "fruit_table", primaryKeys = {"id", "item"})
public class FruitDbo {

    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @NonNull
    @ColumnInfo(name = "item")
    private String item;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "farm_name")
    private String farmName;

    @ColumnInfo(name = "phone")
    private String phone;

    public FruitDbo(@NonNull String id, @NonNull String item, String category, String farmName, String phone) {
        this.id = id;
        this.item = item;
        this.category = category;
        this.farmName = farmName;
        this.phone = phone;
    }

    @NonNull
    public String getId() {
        return id;
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
