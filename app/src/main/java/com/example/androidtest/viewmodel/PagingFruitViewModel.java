package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.paging.ui.FruitDataSourceFactory;

public class PagingFruitViewModel extends ViewModel {

    private LiveData<PagedList<FruitBo>> fruitPagedListLiveData;

    public PagingFruitViewModel() {

        PagedList.Config config = new PagedList.Config.Builder().setPageSize(10).build();
        fruitPagedListLiveData = new LivePagedListBuilder<>(new FruitDataSourceFactory(), config).build();

    }

    public LiveData<PagedList<FruitBo>> getFruitPagedListLiveData() {
        return fruitPagedListLiveData;
    }
}
