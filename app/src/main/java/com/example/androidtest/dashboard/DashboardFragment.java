package com.example.androidtest.dashboard;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;
import com.example.androidtest.contraint.ConstraintActivity;
import com.example.androidtest.paging.ui.PagingActivity;

public class DashboardFragment extends BaseFragment implements View.OnClickListener {

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    private TextView constraintLabel;

    private TextView pagingLabel;

    @Override
    protected int fragmentLayout() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected void configureToolbar(Toolbar toolbar) {
        toolbar.setTitle(R.string.dashboard_title);
    }

    @Override
    protected void setupView(View view) {
        constraintLabel = view.findViewById(R.id.dashboard_constraint_label);
        constraintLabel.setOnClickListener(this);
        pagingLabel = view.findViewById(R.id.dashboard_paging_label);
        pagingLabel.setOnClickListener(this);
    }

    //region OnClickListener Interface

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dashboard_constraint_label:
                ConstraintActivity.startActivity(getActivity());
                break;

            case R.id.dashboard_paging_label:
                PagingActivity.startActivity(getActivity());
                break;

            default:
                Log.w(getClass().getSimpleName(), "Id not found to match with the cases.");
        }
    }

    //endregion


}
