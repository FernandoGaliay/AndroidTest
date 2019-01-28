package com.example.androidtest.api.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.mapper.FruitMapper;
import com.example.androidtest.db.FruitRoomDatabase;
import com.example.androidtest.db.dao.FruitDao;

import java.util.List;

public class FruitDatabaseDataSource extends FruitDataSource<FruitBo> {

    private FruitDao fruitDao;

    private LiveData<List<FruitBo>> fruitsLiveData = new MutableLiveData<>();

    public FruitDatabaseDataSource(Application application) {

        FruitRoomDatabase db = FruitRoomDatabase.getDatabase(application);
        fruitDao = db.fruitDao();

    }


    public LiveData<List<FruitDbo>> getAsyncData(int limit, int offset) {

        return fruitDao.getAsync(limit, offset);

    }

    @Deprecated
    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBo>> callback) {

        callback.onSuccess(getData(limit, offset));

    }

    @Override
    public List<FruitBo> getData(int limit, int offset) {

        return FruitMapper.dboToBo(fruitDao.get(limit, offset));

    }

    public LiveData<List<FruitBo>> getFruitsLiveData() {

        return fruitsLiveData;

    }

    public boolean exists(int limit, int offset) {

        return fruitDao.count(limit, offset) > 0;

    }
}
