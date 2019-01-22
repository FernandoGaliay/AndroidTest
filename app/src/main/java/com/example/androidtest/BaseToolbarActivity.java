package com.example.androidtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseToolbarActivity extends AppCompatActivity {

    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(getContainerId(), fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    protected abstract Toolbar getToolbar();

    protected abstract int getLayoutId();

    protected abstract int getContainerId();
}
