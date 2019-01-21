package com.example.androidtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseToolbarActivity extends AppCompatActivity {

    public void setFragment(int containerId, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    protected abstract Toolbar getToolbar();
}
