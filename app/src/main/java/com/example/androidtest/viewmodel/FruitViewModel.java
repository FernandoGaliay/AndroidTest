package com.example.androidtest.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.androidtest.data.bo.FruitBO;

import java.util.List;

public class FruitViewModel extends ViewModel {

    private MutableLiveData<List<FruitBO>> fruitsLiveData = new MutableLiveData<>();
}
