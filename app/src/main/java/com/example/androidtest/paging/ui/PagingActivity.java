package com.example.androidtest.paging.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.androidtest.BaseToolbarActivity;
import com.example.androidtest.R;

public class PagingActivity extends BaseToolbarActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, PagingActivity.class);
        context.startActivity(intent);
    }

    private Toolbar toolbar;

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_paging;
    }

    @Override
    protected int getContainerId() {
        return R.id.paging_container;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.paging_toolbar);
        setFragment(PagingFragment.newInstance());
    }
}
