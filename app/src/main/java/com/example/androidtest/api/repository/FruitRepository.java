package com.example.androidtest.api.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.mapper.FruitMapper;

import java.util.List;

public class FruitRepository {

    //region Initialization

    private FruitApiDataSource fruitApiDataSource;

    private FruitCacheDataSource fruitCacheDataSource;

    private FruitDatabaseDataSource fruitDatabaseDataSource;

    public FruitRepository() {

        fruitApiDataSource = new FruitApiDataSource();
        fruitCacheDataSource = new FruitCacheDataSource();
        fruitDatabaseDataSource = new FruitDatabaseDataSource();

    }

    //endregion

    private LiveData<List<FruitBo>> fruitsLiveData = new MediatorLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    //region Repository Calls

    public LiveData<List<FruitBo>> getFruits(int limit, int offset) {

        if (fruitCacheDataSource.exists(limit, offset)) {

            ((MutableLiveData<List<FruitBo>>) fruitsLiveData).setValue(fruitCacheDataSource.getData(limit, offset));

        } else if (fruitDatabaseDataSource.exists(limit, offset)) {

            ((MediatorLiveData) fruitsLiveData).addSource(fruitDatabaseDataSource.getAsyncData(limit, offset),

                    fruitsDboList -> {

                        if (fruitsDboList instanceof List) {

                            ((MediatorLiveData<List<FruitBo>>) fruitsLiveData).postValue(FruitMapper.dboToBo((List<FruitDbo>) fruitsDboList));

                        }

                    });

        } else {

            fruitApiDataSource.getAsyncData(limit, offset, new FruitDataSource.Callback<List<FruitBo>>() {

                @Override
                public void onSuccess(List<FruitBo> data) {

                    fruitCacheDataSource.setData(limit, offset, data);
                    ((MutableLiveData<List<FruitBo>>) fruitsLiveData).setValue(data);

                }

                @Override
                public void onError(String message) {

                    fruitCacheDataSource.setData(limit, offset, null);
                    errorLiveData.setValue(message);

                }
            });

        }

        return fruitsLiveData;

    }

    //endregion

    //region Getters And Setters

    public LiveData<List<FruitBo>> getFruitsLiveData() {

        return fruitsLiveData;

    }

    public LiveData<String> getErrorLiveData() {

        return errorLiveData;

    }

    //endregion
}
