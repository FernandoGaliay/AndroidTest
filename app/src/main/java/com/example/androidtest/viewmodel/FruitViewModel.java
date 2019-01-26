package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.androidtest.api.repository.FruitRepository;
import com.example.androidtest.data.bo.FruitBO;

import java.util.List;

public class FruitViewModel extends ViewModel {

    private FruitRepository fruitRepository;

    private MutableLiveData<List<FruitBO>> fruitsLiveData;

    private MutableLiveData<String> errorLiveData;

    public FruitViewModel() {

        fruitRepository = new FruitRepository();
        fruitsLiveData = fruitRepository.getFruitsLiveData();
        errorLiveData = fruitRepository.getErrorLiveData();

    }

    //region Getters

    public LiveData<List<FruitBO>> getFruits(){

        return fruitsLiveData;

    }

    public LiveData<String> getError(){

        return errorLiveData;

    }

    //endregion

    //region Use Cases

    public void searchFruits(int limit, int offset){

        fruitRepository.getFruits(limit, offset);

    }

    //endregion
}
