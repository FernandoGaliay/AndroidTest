package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.androidtest.api.repository.FruitRepository;
import com.example.androidtest.data.FruitQueryBO;
import com.example.androidtest.data.bo.FruitBO;

import java.util.List;

public class FruitViewModel extends ViewModel {

    private FruitRepository fruitRepository;

    private MutableLiveData<FruitQueryBO> fruitQueryLiveData = new MutableLiveData<>();

    private LiveData<List<FruitBO>> fruitsLiveData = Transformations.map(fruitQueryLiveData, query ->
            fruitRepository.getFruits(query.getLimit(), query.getOffset()).getValue()
    );

    private MutableLiveData<String> errorLiveData;

    public FruitViewModel() {

        fruitRepository = new FruitRepository();
        errorLiveData = fruitRepository.getErrorLiveData();

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

    public void searchFruits(int limit, int offset) {

        searchFruits(limit, offset);

    }

    public void nextSearchFruits() {

        FruitQueryBO fruitQuery = fruitQueryLiveData.getValue();
        fruitQuery.setOffset(fruitQuery.getOffset() + 1);
        fruitQueryLiveData.setValue(fruitQuery);
    }

    //endregion
}
