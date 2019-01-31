package com.example.androidtest.paging.datasource;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.repository.FruitDataSource;
import com.example.androidtest.data.repository.FruitRepository;

import java.util.List;

public class FruitPositionalDataSource extends PositionalDataSource<FruitBo> {

    private FruitRepository fruitRepository;

    public FruitPositionalDataSource() {

        fruitRepository = new FruitRepository();

    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<FruitBo> callback) {

        int start = params.requestedStartPosition;
        int size = params.pageSize;

        fruitRepository.getFruitPaging(size, start, new FruitDataSource.Callback<List<FruitBo>>() {

            @Override
            public void onSuccess(List<FruitBo> data) {

                callback.onResult(data, params.requestedStartPosition, 1000);

            }

            @Override
            public void onError(String message) {

                // TODO

            }

        });

    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<FruitBo> callback) {

        int start = params.startPosition;
        int size = params.loadSize;

        fruitRepository.getFruitPaging(size, start, new FruitDataSource.Callback<List<FruitBo>>() {

            @Override
            public void onSuccess(List<FruitBo> data) {

                callback.onResult(data);

            }

            @Override
            public void onError(String message) {

                // TODO

            }

        });


    }

}
