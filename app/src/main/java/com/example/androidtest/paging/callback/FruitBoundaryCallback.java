package com.example.androidtest.paging.callback;

import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.repository.FruitApiDataSource;
import com.example.androidtest.data.repository.FruitDataSource;
import com.example.androidtest.data.repository.FruitDatabaseDataSource;

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

        apiDataSource.getAsyncData(queryBo.getLimit(), queryBo.getOffset(), new FruitDataSource.Callback<List<FruitBo>>() {

            @Override
            public void onSuccess(List<FruitBo> data) {

                databaseDataSource.setData(data);

            }

            @Override
            public void onError(String message) {

                // TODO

            }
        });

        queryBo.nextQuery();
        
    }
}
