package com.example.androidtest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.repository.fruit.FruitRepository;
import com.example.androidtest.paging.datasource.FruitDataSourceFactory;

public class PagingFruitViewModel extends ViewModel {

    private FruitRepository fruitRepository;

    private LiveData<PagedList<FruitBo>> fruitPagedListLiveData;

    public PagingFruitViewModel() {

        fruitRepository = new FruitRepository();
        PagedList.Config config = new PagedList.Config.Builder().setPageSize(10).build();
        fruitPagedListLiveData = new LivePagedListBuilder<>(new FruitDataSourceFactory(), config).build();

    }

    public LiveData<PagedList<FruitBo>> getFruitPagedListLiveData() {
        return fruitPagedListLiveData;

    }

    public LiveData<PagedList<FruitDbo>> getFruitPagedByName(String fruitName) {
        return fruitRepository.getFruitPagingByName(fruitName);

    }
}
