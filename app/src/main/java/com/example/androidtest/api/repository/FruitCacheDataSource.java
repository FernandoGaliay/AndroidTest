package com.example.androidtest.api.repository;

import android.util.Log;

import com.example.androidtest.data.bo.FruitBO;

import java.util.List;

public class FruitCacheDataSource extends FruitDataSource<FruitBO> {

    private List<FruitBO> fruitBOList;

    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBO>> callback) {

        callback.onSuccess(getData(limit, offset));

    }

    @Override
    public List<FruitBO> getData(int limit, int offset) {

        int pageStart = limit * 10;

        try {

            return getFruitBOList().subList(pageStart, pageStart + offset);

        } catch (Exception e) {

            Log.w(getClass().getSimpleName(), e.getMessage());
            return null;

        }
    }

    private List<FruitBO> getFruitBOList() {

        if (fruitBOList == null) {
            // TODO search data in preferences
        }

        return fruitBOList;

    }

    public void setData(List<FruitBO> fruitBOList) {

        this.fruitBOList = fruitBOList;
        // TODO save data in preferences

    }

}