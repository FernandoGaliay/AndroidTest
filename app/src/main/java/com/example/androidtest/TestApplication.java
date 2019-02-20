package com.example.androidtest;

import android.app.Application;

public class TestApplication extends Application {

    private static volatile TestApplication INSTANCE;

    public TestApplication() {
        INSTANCE = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        android.support.v7.preference.PreferenceManager
                .setDefaultValues(this, R.xml.preference, false);
    }

    public static TestApplication getINSTANCE(){
        return INSTANCE;
    }
}
