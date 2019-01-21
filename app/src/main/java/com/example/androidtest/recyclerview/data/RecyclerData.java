package com.example.androidtest.recyclerview.data;

import java.util.Date;

public class RecyclerData {

    private String name;

    private Date fromDate;

    private String image;

    private int age;

    private boolean isEnabled;

    private String message;

    private boolean isFavorite;

    public RecyclerData() {
    }

    public RecyclerData(String name, Date fromDate, String image, int age, boolean isEnabled, String message, boolean isFavorite) {
        this.name = name;
        this.fromDate = fromDate;
        this.image = image;
        this.age = age;
        this.isEnabled = isEnabled;
        this.message = message;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
