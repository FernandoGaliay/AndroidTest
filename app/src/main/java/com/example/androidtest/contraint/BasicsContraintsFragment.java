package com.example.androidtest.contraint;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;

public class BasicsContraintsFragment extends BaseFragment {

    public static BasicsContraintsFragment newInstance() {
        BasicsContraintsFragment fragment = new BasicsContraintsFragment();
        return fragment;
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_basics_contraint;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.basics_contraints_title);
    }

    @Override
    protected void setupView(View view) {

    }
}
