package com.example.androidtest.recyclerview.ui;

import android.support.v7.widget.Toolbar;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;

import org.jetbrains.annotations.Nullable;

public class RecyclerViewFragment extends BaseFragment {

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.recycler_title);
    }

    @Nullable
    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        return fragment;
    }
}
