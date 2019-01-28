package com.example.androidtest.api.repository;

import java.util.List;

public abstract class FruitDataSource<T> {

    protected abstract void getAsyncData(int limit, int offset, Callback<List<T>> callback);

    protected abstract List<T> getData(int limit, int offset);

    public interface Callback<T> {

        void onSuccess(T data);

        void onError(String message);

    }

}
