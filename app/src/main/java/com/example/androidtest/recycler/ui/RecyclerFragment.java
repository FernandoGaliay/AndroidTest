package com.example.androidtest.recycler.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
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

public class RecyclerFragment extends BaseFragment {

    public static Fragment newInstance() {

        RecyclerFragment fragment = new RecyclerFragment();
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
        fruitRecycler.setHasFixedSize(true);
        fruitRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fruitRecycler.setAdapter(new RecyclerAdapter());
        viewModel = ViewModelProviders.of(this).get(FruitViewModel.class);
        viewModel.getFruits().observe(this, this::onFruitsReceived);
        viewModel.getError().observe(this, this::onErrorReceived);
        viewModel.nextFruitSearch();
        FloatingActionButton addButton = view.findViewById(R.id.paging_button_add);
        addButton.setOnClickListener(clickedView -> viewModel.add());

    }

    private void onFruitsReceived(List<FruitBo> fruitBoList) {

        if (fruitRecycler.getAdapter() instanceof RecyclerAdapter) {

            ((RecyclerAdapter) fruitRecycler.getAdapter()).addData(fruitBoList);

        }

    }

    private void onErrorReceived(String error) {

        //TODO

    }
}
