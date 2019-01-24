package com.example.androidtest.recyclerview.ui;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;

public class RecyclerViewFragment extends BaseFragment {

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        return fragment;
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.recycler_title);
    }


    @Override
    protected void setupView(View view) {

    }
}
