package com.example.androidtest.dashboard;

import android.support.v7.widget.Toolbar;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;

public class DashboardFragment extends BaseFragment {

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.dashboard_title);
    }
}
