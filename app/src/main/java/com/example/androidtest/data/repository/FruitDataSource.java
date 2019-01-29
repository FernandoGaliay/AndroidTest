package com.example.androidtest.data.repository;

import java.util.List;

public abstract class FruitDataSource<T> {

    public abstract void getAsyncData(int limit, int offset, Callback<List<T>> callback);

    public abstract List<T> getData(int limit, int offset);

    public interface Callback<R> {

        void onSuccess(R data);

        void onError(String message);

    }

}
