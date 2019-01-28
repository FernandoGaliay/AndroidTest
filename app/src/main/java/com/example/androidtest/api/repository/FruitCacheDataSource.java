package com.example.androidtest.api.repository;

import android.util.Log;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;

import java.util.HashMap;
import java.util.List;

public class FruitCacheDataSource extends FruitDataSource<FruitBo> {

    private HashMap<FruitQueryBo, List<FruitBo>> queryFruitListMap;

    FruitCacheDataSource() {

        queryFruitListMap = new HashMap<>();

    }

    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBo>> callback) {

        callback.onSuccess(getData(limit, offset));

    }

    @Override
    public List<FruitBo> getData(int limit, int offset) {

        try {

            return getFruitBoList(limit, offset);

        } catch (Exception e) {

            Log.w(getClass().getSimpleName(), e.getMessage());
            return null;

        }
    }

    private List<FruitBo> getFruitBoList(int limit, int offset) {

        List<FruitBo> fruitBoList = queryFruitListMap.get(new FruitQueryBo(limit, offset));

        if (fruitBoList == null) {
            // TODO search data in preferences
        }

        return fruitBoList;

    }

    void setData(int limit, int offset, List<FruitBo> FruitBoList) {

        queryFruitListMap.put(new FruitQueryBo(limit, offset), FruitBoList);
        // TODO save data in preferences

    }

    boolean exists(int limit, int offset) {

        return getData(limit, offset) != null;

    }

}