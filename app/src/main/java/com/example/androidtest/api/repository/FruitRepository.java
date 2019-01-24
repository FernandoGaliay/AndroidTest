package com.example.androidtest.api.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.data.FruitDTO;

import java.util.List;

public class FruitRepository {

    //region Singletone

    private static FruitRepository fruitRepository;

    public static FruitRepository newInstance() {
        if (fruitRepository == null) {
            fruitRepository = new FruitRepository();
        }
        return fruitRepository;
    }

    private FruitRepository() {
        // Nothing to do
    }

    //endregion

    //region Calls

    private MutableLiveData<List<FruitDTO>> fruitsLiveData = new MutableLiveData<>();

    public LiveData<List<FruitDTO>> getFruits() {
        if (fruitRepository.fruitsLiveData.getValue() == null) {
            FruitApiRequest.requestFruits((fruitRepository.fruitsLiveData));
        }
        return fruitRepository.fruitsLiveData;
    }

    //endregion

}
