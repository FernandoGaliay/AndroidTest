package com.example.androidtest.paging.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.EspressoIdlingResource;
import com.example.androidtest.R;
import com.example.androidtest.data.dbo.FruitDbo;
import com.example.androidtest.data.dbo.util.FruitDboDiffUtilItemCallback;
import com.example.androidtest.viewmodel.PagingFruitViewModel;

public class PagingFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new PagingFragment();
    }

    private PagingFruitViewModel viewModel;
    private RecyclerView fruitRecycler;
    private ProgressBar fruitLoader;
    private EditText fruitSearchInput;
    private PagingDboAdapter adapter;
    private Button fruitSearchBtn;


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

        fruitSearchInput = view.findViewById(R.id.paging_input_search);
        fruitLoader = view.findViewById(R.id.paging_loader);
        fruitRecycler = view.findViewById(R.id.paging_list_fruit);
        fruitSearchBtn = view.findViewById(R.id.paging_btn_search);

        fruitRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fruitRecycler.setHasFixedSize(true);
        adapter = new PagingDboAdapter(new FruitDboDiffUtilItemCallback());
        fruitRecycler.setAdapter(adapter);
        fruitSearchBtn.setOnClickListener(itemView -> searchFruit(fruitSearchInput.getText().toString()));
        viewModel = ViewModelProviders.of(this).get(PagingFruitViewModel.class);

    }

    private void searchFruit(String searchTerm) {
        viewModel.getFruitPagedByName(searchTerm).observe(this, this::onFruitsReceived);
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
