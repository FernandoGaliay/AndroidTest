package com.example.androidtest.api.repository;

import android.util.Log;

import com.example.androidtest.data.FruitQueryBO;
import com.example.androidtest.data.bo.FruitBO;

import java.util.HashMap;
import java.util.List;

public class FruitCacheDataSource extends FruitDataSource<FruitBO> {

    private HashMap<FruitQueryBO, List<FruitBO>> queryFruitListMap;

    public FruitCacheDataSource() {
        queryFruitListMap = new HashMap<>();
    }

    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBO>> callback) {

        callback.onSuccess(getData(limit, offset));

    }

    @Override
    public List<FruitBO> getData(int limit, int offset) {

        try {

            return getFruitBOList(limit, offset);

        } catch (Exception e) {

            Log.w(getClass().getSimpleName(), e.getMessage());
            return null;

        }
    }

    private List<FruitBO> getFruitBOList(int limit, int offset) {

        List<FruitBO> fruitBOList = queryFruitListMap.get(new FruitQueryBO(limit, offset));

        if (fruitBOList == null) {
            // TODO search data in preferences
        }

        return fruitBOList;

    }

    public void setData(int limit, int offset, List<FruitBO> fruitBOList) {

        queryFruitListMap.put(new FruitQueryBO(limit, offset), fruitBOList);
        // TODO save data in preferences

    }

}