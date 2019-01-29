package com.example.androidtest;

import android.app.Application;

public class TestApplication extends Application {

    private static volatile TestApplication INSTANCE;

    public TestApplication() {
        INSTANCE = this;
    }

    public static TestApplication getINSTANCE(){
        return INSTANCE;
    }
}
