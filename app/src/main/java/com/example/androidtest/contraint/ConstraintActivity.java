package com.example.androidtest.contraint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.androidtest.BaseToolbarActivity;
import com.example.androidtest.R;

public class ConstraintActivity extends BaseToolbarActivity {

    public static void startActivity(Context context){
        Intent intent = new Intent(context, ConstraintActivity.class);
        context.startActivity(intent);
    }

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.basic_constraints_toolbar);
        setFragment(BasicsContraintsFragment.newInstance());
    }

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_basic_contraints;
    }

    @Override
    protected int getContainerId() {
        return R.id.basic_constraints_container;
    }


}
