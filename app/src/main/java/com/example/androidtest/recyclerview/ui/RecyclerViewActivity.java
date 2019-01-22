package com.example.androidtest.recyclerview.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.androidtest.BaseToolbarActivity;
import com.example.androidtest.R;

import butterknife.BindView;

public class RecyclerViewActivity extends BaseToolbarActivity {

    @BindView(R.id.recyclerview_toolbar)
    Toolbar toolbar;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reciclerview;
    }

    @Override
    protected int getContainerId() {
        return R.id.recyclerview_container;
    }
}
