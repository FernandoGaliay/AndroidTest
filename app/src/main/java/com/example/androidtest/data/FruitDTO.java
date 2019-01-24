package com.example.androidtest.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FruitDTO implements Serializable {

    @SerializedName("item")
    private String item;

    @SerializedName("category")
    private String category;

    @SerializedName("farm_name")
    private String farmName;

    @SerializedName("phone1")
    private String phone;

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
