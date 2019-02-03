package com.example.androidtest.paging.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.viewmodel.PagingFruitViewModel;

public class PagingFragment extends BaseFragment {

    public static Fragment newInstance() {

        return new PagingFragment();

    }

    private PagingFruitViewModel viewModel;

    private RecyclerView fruitRecycler;

    private ProgressBar fruitLoader;

    private PagingDboAdapter adapter;

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
        fruitRecycler.setHasFixedSize(true);
        adapter = new PagingDboAdapter(new DiffUtil.ItemCallback<FruitDbo>() {

            @Override
            public boolean areItemsTheSame(@NonNull FruitDbo first, @NonNull FruitDbo second) {

                return first.getId().equals(second.getId());

            }

            @Override
            public boolean areContentsTheSame(@NonNull FruitDbo first, @NonNull FruitDbo second) {

                return first.getId().equals(second.getId()) &&
                        first.getPhone().equals(second.getPhone()) &&
                        first.getFarmName().equals(second.getFarmName()) &&
                        first.getCategory().equals(second.getCategory()) &&
                        first.getItem().equals(second.getItem());

            }

        });
        fruitRecycler.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(PagingFruitViewModel.class);
        viewModel.getFruitPaged().observe(this, this::onFruitsReceived);

    }

    private void onFruitsReceived(PagedList<FruitDbo> fruitBoList) {

        fruitLoader.setVisibility(View.GONE);

        if (fruitRecycler.getAdapter() instanceof PagingDboAdapter) {

            adapter.submitList(fruitBoList);

        }

    }

    private void onErrorReceived(String error) {

        //TODO

    }
}
