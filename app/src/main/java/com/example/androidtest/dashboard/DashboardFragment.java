package com.example.androidtest.dashboard;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtest.BaseFragment;
import com.example.androidtest.R;
import com.example.androidtest.contraint.ConstraintActivity;
import com.example.androidtest.notification.NotificationActivity;
import com.example.androidtest.paging.ui.PagingActivity;
import com.example.androidtest.recycler.ui.RecyclerActivity;
import com.example.androidtest.snackbar.SnackbarHelper;

public class DashboardFragment extends BaseFragment implements View.OnClickListener {

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    private TextView constraintLabel;
    private TextView recyclerLabel;
    private TextView pagingLabel;
    private TextView snackbarLabel;
    private TextView notificationLabel;

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
        recyclerLabel = view.findViewById(R.id.dashboard_recycler_label);
        recyclerLabel.setOnClickListener(this);
        pagingLabel = view.findViewById(R.id.dashboard_paging_label);
        pagingLabel.setOnClickListener(this);
        snackbarLabel = view.findViewById(R.id.dashboard_snackbar_label);
        snackbarLabel.setOnClickListener(this);
        notificationLabel = view.findViewById(R.id.dashboard_notification_label);
        notificationLabel.setOnClickListener(this);
    }

    //region OnClickListener Interface

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dashboard_constraint_label:
                ConstraintActivity.startActivity(getActivity());
                break;

            case R.id.dashboard_recycler_label:
                RecyclerActivity.startActivity(getActivity());
                break;

            case R.id.dashboard_paging_label:
                PagingActivity.startActivity(getActivity());
                break;
            case R.id.dashboard_snackbar_label:
                SnackbarHelper.show(getActivity(), v);
                break;
            case R.id.dashboard_notification_label:
                NotificationActivity.startActivity(getActivity());
                break;
            default:
                Log.w(getClass().getSimpleName(), "Id not found to match with the cases.");
        }
    }

    //endregion


}
