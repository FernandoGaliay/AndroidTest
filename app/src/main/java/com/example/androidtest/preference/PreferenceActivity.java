package com.example.androidtest.preference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.androidtest.BaseToolbarActivity;
import com.example.androidtest.R;

public class PreferenceActivity extends BaseToolbarActivity {

    private Toolbar toolbar;

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_preference;
    }

    @Override
    protected int getContainerId() {
        return R.id.preference_container;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.preference_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setFragment(PreferenceFragment.newInstance());
    }
}
