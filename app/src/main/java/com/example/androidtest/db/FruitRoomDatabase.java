package com.example.androidtest.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.dbo.LocationDbo;
import com.example.androidtest.db.dao.CountryDao;
import com.example.androidtest.db.dao.FruitDao;

@Database(entities = {FruitDbo.class, CountryDbo.class}, version = 1)
public abstract class FruitRoomDatabase extends RoomDatabase {

    private static volatile FruitRoomDatabase INSTANCE;

    public static FruitRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {

            synchronized (FruitRoomDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FruitRoomDatabase.class, "fruit_database")
                            .build();

                }

            }

        }

        return INSTANCE;

    }

    public abstract FruitDao fruitDao();

    public abstract CountryDao countryDao();
}
