package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;
import com.example.androidtest.data.repository.FruitRepository;

import java.util.Calendar;
import java.util.List;

public class FruitViewModel extends ViewModel {

    private FruitRepository fruitRepository;

    private MutableLiveData<FruitQueryBo> fruitQuery = new MutableLiveData<>();

    private LiveData<List<FruitBo>> fruitsLiveData;

    private LiveData<String> errorLiveData;

    public FruitViewModel() {

        fruitRepository = new FruitRepository();
        errorLiveData = fruitRepository.getErrorLiveData();
        fruitsLiveData = Transformations.switchMap(fruitQuery,
                fruitQuery -> fruitRepository.getFruitsByLimitAndOffset(fruitQuery.getLimit(), fruitQuery.getOffset()));

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

        if (fruitQuery.getValue() == null) {

            fruitQuery.setValue(new FruitQueryBo());

        } else {

            fruitQuery.setValue(fruitQuery.getValue().nextQuery());

        }

    }

    public void add() {

        FruitBo randomFruit = new FruitBo();
        randomFruit.setId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        randomFruit.setCategory("Citrico");
        randomFruit.setPhone("666666666");
        randomFruit.setItem("Naranja");
        randomFruit.setFarmName("Frutería Emil");
        fruitRepository.setData(randomFruit);

    }

    //endregion
}
