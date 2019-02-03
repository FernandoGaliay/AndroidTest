package com.example.androidtest.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.data.dbo.CountryUtil;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.db.dao.CountryDao;
import com.example.androidtest.db.dao.FruitDao;

@Database(entities = {FruitDbo.class, CountryDbo.class}, version = 2)
public abstract class TestRoomDatabase extends RoomDatabase {

    private static volatile TestRoomDatabase INSTANCE;

    public static TestRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {

            synchronized (TestRoomDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TestRoomDatabase.class, "fruit_database")
                            .addCallback(new Callback() {
                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    new Thread(){

                                        @Override
                                        public void run() {

                                            CountryDao countryDao = INSTANCE.countryDao();
                                            countryDao.deleteAll();
                                            countryDao.insert(CountryUtil.getCountries());

                                        }

                                    }.start();
                                }
                            })
                            .build();

                }

            }

        }

        return INSTANCE;

    }

    public abstract FruitDao fruitDao();

    public abstract CountryDao countryDao();
}
