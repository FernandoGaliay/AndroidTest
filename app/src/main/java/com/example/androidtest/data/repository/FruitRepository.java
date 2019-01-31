package com.example.androidtest.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.mapper.FruitMapper;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository {

    //region Initialization

    private FruitApiDataSource fruitApiDataSource;

    private FruitCacheDataSource fruitCacheDataSource;

    private FruitDatabaseDataSource fruitDatabaseDataSource;

    public FruitRepository() {

        fruitApiDataSource = new FruitApiDataSource();
        fruitCacheDataSource = FruitCacheDataSource.getInstace();
        fruitDatabaseDataSource = new FruitDatabaseDataSource();

    }

    //endregion

    private LiveData<List<FruitBo>> fruitsLiveData = new MediatorLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    //region Repository Calls

    public LiveData<List<FruitBo>> getFruits(int limit, int offset) {

        if (!fruitsLiveData.hasObservers()) {

            ((MediatorLiveData) fruitsLiveData).addSource(fruitDatabaseDataSource.getAll(), (Observer<List<FruitDbo>>) fruitDboList -> {

                if (fruitDboList != null
                        && !fruitDboList.isEmpty()) {

                    fruitCacheDataSource.setData(limit, offset, FruitMapper.dboToBo(fruitDboList));
                    ((MediatorLiveData<List<FruitBo>>) fruitsLiveData).postValue(FruitMapper.dboToBo(fruitDboList));

                }

            });
        }

        if (fruitCacheDataSource.exists(limit, offset)) {

            ((MutableLiveData<List<FruitBo>>) fruitsLiveData).setValue(fruitCacheDataSource.getData(limit, offset));

        } else {

            fruitApiDataSource.getAsyncData(limit, offset, new FruitDataSource.Callback<List<FruitBo>>() {

                @Override
                public void onSuccess(List<FruitBo> data) {

                    fruitCacheDataSource.setData(limit, offset, data);
                    fruitDatabaseDataSource.setData(data); // Modify room database will notify the observer of the MediatorLiveData

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

    public void getFruitPaging(int limit, int offset, FruitApiDataSource.Callback<List<FruitBo>> callback) {

        fruitApiDataSource.getAsyncData(limit, offset, callback);

    }

    public void add(FruitBo randomFruit) {

        List<FruitBo> newRandomFruitList = new ArrayList<>();
        newRandomFruitList.add(randomFruit);
        fruitDatabaseDataSource.setData(newRandomFruitList);

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
