package com.example.androidtest.data.repository.fruit;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;

import com.example.androidtest.TestApplication;
import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.mapper.FruitMapper;
import com.example.androidtest.db.FruitRoomDatabase;
import com.example.androidtest.db.dao.FruitDao;

import java.util.List;

public class FruitDatabaseDataSource extends FruitDataSource<FruitBo> {

    private FruitDao fruitDao;

    public FruitDatabaseDataSource() {

        FruitRoomDatabase db = FruitRoomDatabase.getDatabase(TestApplication.getINSTANCE());
        fruitDao = db.fruitDao();

    }

    public DataSource.Factory<Integer, FruitDbo> getPaging() {

        return fruitDao.getPaging();

    }

    public LiveData<List<FruitDbo>> getAll() {

        return fruitDao.getAll();

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

    public void setData(List<FruitBo> fruitBoList) {

        new Thread() {

            @Override
            public void run() {

                fruitDao.insert(FruitMapper.boToDbo(fruitBoList));

            }

        }.start();

    }
}
