package com.example.androidtest.data.repository;

import android.arch.lifecycle.LiveData;

import com.example.androidtest.TestApplication;
import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.mapper.FruitMapper;
import com.example.androidtest.db.FruitRoomDatabase;
import com.example.androidtest.db.dao.FruitDao;

import java.util.List;

public class FruitDatabaseDataSource extends FruitDataSource<FruitBo> {

    private FruitDao fruitDao;

    FruitDatabaseDataSource() {

        FruitRoomDatabase db = FruitRoomDatabase.getDatabase(TestApplication.getINSTANCE());
        fruitDao = db.fruitDao();

    }


    LiveData<List<FruitDbo>> getAsyncData(int limit, int offset) {

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

    boolean exists(int limit, int offset) {

        Integer count = fruitDao.count(limit, offset).getValue();
        return count != null && count > 0;

    }

    void setData(List<FruitBo> fruitBoList) {

        new Thread() {

            @Override
            public void run() {

                fruitDao.insert(FruitMapper.boToDbo(fruitBoList));

            }

        }.start();

    }
}
