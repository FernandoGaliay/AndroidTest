package com.example.androidtest.paging.datasource;

import android.arch.paging.DataSource;

import com.example.androidtest.data.bo.FruitBo;

public class FruitDataSourceFactory extends DataSource.Factory<Integer, FruitBo> {

    @Override
    public DataSource<Integer, FruitBo> create() {

        return new FruitPositionalDataSource();

    }

}
