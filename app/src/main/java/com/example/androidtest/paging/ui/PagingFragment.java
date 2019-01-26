package com.example.androidtest.paging.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;
import com.example.androidtest.data.bo.FruitBO;
import com.example.androidtest.viewmodel.FruitViewModel;

import java.util.List;

public class PagingFragment extends BaseFragment {

    public static Fragment newInstance() {
        PagingFragment fragment = new PagingFragment();
        return fragment;
    }

    private FruitViewModel viewModel;

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_paging;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.paging_title);
    }

    @Override
    protected void setupView(View view) {

        viewModel = ViewModelProviders.of(this).get(FruitViewModel.class);
        viewModel.getFruits().observe(this, fruitBOList -> {
            onFruitsReceived(fruitBOList);
        });
        viewModel.getError().observe(this, error -> {
            onErrorReceived(error);
        });
        viewModel.searchFruits(10, 0);

    }

    private void onFruitsReceived(List<FruitBO> fruitBOList) {

        //TODO

    }

    private void onErrorReceived(String error) {

        //TODO

    }
}
