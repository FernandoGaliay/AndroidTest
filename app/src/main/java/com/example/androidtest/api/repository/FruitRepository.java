package com.example.androidtest.api.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.data.bo.FruitBO;

import java.util.List;

public class FruitRepository {

    private FruitApiDataSource fruitApiDataSource;

    private FruitCacheDataSource fruitCacheDataSource;

    public FruitRepository() {

        fruitApiDataSource = new FruitApiDataSource();
        fruitCacheDataSource = new FruitCacheDataSource();

    }

    //region Repository Calls

    private MutableLiveData<List<FruitBO>> fruitsLiveData = new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public LiveData<List<FruitBO>> getFruits(int limit, int offset) {

        if (fruitCacheDataSource.getData(limit, offset) != null) {

            fruitsLiveData.setValue(fruitCacheDataSource.getData(limit, offset));

        } else {

            fruitApiDataSource.getAsyncData(limit, offset, new FruitDataSource.Callback<List<FruitBO>>() {
                @Override
                public void onSuccess(List<FruitBO> data) {

                    fruitCacheDataSource.setData(data);
                    fruitsLiveData.setValue(data);

                }

                @Override
                public void onError(String message) {

                    fruitCacheDataSource.setData(null);
                    errorLiveData.setValue(message);

                }
            });

        }

        return fruitsLiveData;
    }

    //endregion

}
