package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.androidtest.api.repository.FruitRepository;
import com.example.androidtest.data.FruitQueryBO;
import com.example.androidtest.data.bo.FruitBO;

import java.util.List;

public class FruitViewModel extends ViewModel {

    private FruitRepository fruitRepository;

    private FruitQueryBO fruitQuery;

    private LiveData<List<FruitBO>> fruitsLiveData;

    private MutableLiveData<String> errorLiveData;

    public FruitViewModel() {

        fruitRepository = new FruitRepository();
        errorLiveData = fruitRepository.getErrorLiveData();
        fruitsLiveData = fruitRepository.getFruitsLiveData();

    }

    //region Getters

    public LiveData<List<FruitBO>> getFruits() {

        return fruitsLiveData;

    }

    public LiveData<String> getError() {

        return errorLiveData;

    }

    //endregion

    //region Use Cases

    public void nextSearchFruits() {

        if (fruitQuery == null) {

            fruitQuery = new FruitQueryBO(10);

        } else {

            fruitQuery.setOffset(fruitQuery.getOffset() + 1);

        }

        fruitRepository.getFruits(fruitQuery.getLimit(), fruitQuery.getOffset());

    }

    //endregion
}
