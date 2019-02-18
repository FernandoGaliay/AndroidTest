package com.example.androidtest.paging.callback;

import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.test.espresso.idling.CountingIdlingResource;

import com.example.androidtest.EspressoIdlingResource;
import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.repository.fruit.FruitApiDataSource;
import com.example.androidtest.data.repository.fruit.FruitDataSource;
import com.example.androidtest.data.repository.fruit.FruitDatabaseDataSource;

import java.util.List;

public class FruitBoundaryCallback extends PagedList.BoundaryCallback<FruitDbo> {

    private static final int ITEMS_PER_REQUEST = 30;

    private FruitApiDataSource apiDataSource;

    private FruitDatabaseDataSource databaseDataSource;

    private FruitQueryBo queryBo;

    public FruitBoundaryCallback(FruitApiDataSource apiDataSource, FruitDatabaseDataSource databaseDataSource) {

        this.apiDataSource = apiDataSource;
        this.databaseDataSource = databaseDataSource;
        queryBo = new FruitQueryBo();
        queryBo.setLimit(ITEMS_PER_REQUEST);

    }

    @Override
    public void onZeroItemsLoaded() {

        requestFruits();

    }

    @Override
    public void onItemAtEndLoaded(@NonNull FruitDbo itemAtEnd) {

        requestFruits();

    }

    private void requestFruits() {
        EspressoIdlingResource.increment();
        apiDataSource.getAsyncData(queryBo.getLimit(), queryBo.getOffset(), new FruitDataSource.Callback<List<FruitBo>>() {

            @Override
            public void onSuccess(List<FruitBo> data) {
                databaseDataSource.setData(data);
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onError(String message) {
                EspressoIdlingResource.decrement();
                // TODO
            }
        });

        queryBo.nextQuery();
        
    }
}
