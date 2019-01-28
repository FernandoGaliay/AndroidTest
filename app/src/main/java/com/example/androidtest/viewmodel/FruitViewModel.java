package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.androidtest.api.repository.FruitRepository;
import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;

import java.util.List;

public class FruitViewModel extends ViewModel {

    private FruitRepository fruitRepository;

    private FruitQueryBo fruitQuery;

    private LiveData<List<FruitBo>> fruitsLiveData;

    private LiveData<String> errorLiveData;

    public FruitViewModel() {

        fruitRepository = new FruitRepository();
        errorLiveData = fruitRepository.getErrorLiveData();
        fruitsLiveData = fruitRepository.getFruitsLiveData();

    }

    //region Getters

    public LiveData<List<FruitBo>> getFruits() {

        return fruitsLiveData;

    }

    public LiveData<String> getError() {

        return errorLiveData;

    }

    //endregion

    //region Use Cases

    public void nextFruitSearch() {

        if (fruitQuery == null) {

            fruitQuery = new FruitQueryBo();

        } else {

            fruitQuery.setOffset(fruitQuery.getOffset() + 1);

        }

        fruitRepository.getFruits(fruitQuery.getLimit(), fruitQuery.getOffset());

    }

    //endregion
}
