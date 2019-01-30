package com.example.androidtest.paging.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;
import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.viewmodel.FruitViewModel;

import java.util.List;

public class PagingFragment extends BaseFragment {

    public static Fragment newInstance() {
        PagingFragment fragment = new PagingFragment();
        return fragment;
    }

    private FruitViewModel viewModel;

    private RecyclerView fruitRecycler;

    private ProgressBar fruitLoader;

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

        fruitLoader = view.findViewById(R.id.paging_loader);
        fruitRecycler = view.findViewById(R.id.paging_list_fruit);
        fruitRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fruitRecycler.setAdapter(new PagingAdapter());
        viewModel = ViewModelProviders.of(this).get(FruitViewModel.class);
        viewModel.getFruits().observe(this, this::onFruitsReceived);
        viewModel.getError().observe(this, this::onErrorReceived);
        viewModel.nextFruitSearch();

    }

    private void onFruitsReceived(List<FruitBo> fruitBoList) {

        if (fruitRecycler.getAdapter() instanceof PagingAdapter) {

            ((PagingAdapter) fruitRecycler.getAdapter()).addData(fruitBoList);

        }

    }

    private void onErrorReceived(String error) {

        //TODO

    }
}
