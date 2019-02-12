package com.example.androidtest.data.repository.fruit;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.mapper.FruitMapper;

import java.util.List;

public class FruitDatabaseDataSource extends FruitDataSource<FruitBo> {

    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBo>> callback) {

    }

    @Override
    public List<FruitBo> getData(int limit, int offset) {
        return null;
    }


    public void setData(List<FruitBo> fruitBoList) {

    }

}
