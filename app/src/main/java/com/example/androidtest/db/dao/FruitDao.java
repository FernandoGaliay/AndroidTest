package com.example.androidtest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.androidtest.data.dbo.FruitDbo;

import java.util.List;

@Dao
public interface FruitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<FruitDbo> fruitDboList);

    @Delete
    void delete(List<FruitDbo> fruitDboList);

    @Query("DELETE FROM fruit_table")
    void deleteAll();

    @Query("SELECT * FROM fruit_table")
    LiveData<List<FruitDbo>> getAll();

    @Query("SELECT * FROM fruit_table LIMIT :limit OFFSET :offset")
    List<FruitDbo> get(int limit, int offset);

    @Query("SELECT * FROM fruit_table LIMIT :limit OFFSET :offset")
    LiveData<List<FruitDbo>> getAsync(int limit, int offset);

    @Query("SELECT COUNT(item) FROM fruit_table LIMIT :limit OFFSET :offset")
    LiveData<Integer> count(int limit, int offset);

    @Query("SELECT * FROM fruit_table")
    DataSource.Factory<Integer, FruitDbo> getPaging();

}
