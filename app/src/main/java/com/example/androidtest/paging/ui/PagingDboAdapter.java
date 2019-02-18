package com.example.androidtest.paging.ui;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.data.dbo.FruitDbo;

public class PagingDboAdapter extends PagedListAdapter<FruitDbo, PagingDboAdapter.ViewHolder> {

    public PagingDboAdapter(@NonNull DiffUtil.ItemCallback<FruitDbo> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recycler_data, viewGroup, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        FruitDbo fruit = getItem(position);

        if (fruit == null) {
            return;
        }

        viewHolder.nameLabel.setText(fruit.getItem());
        viewHolder.dateLabel.setText(fruit.getCategory());

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView nameLabel;
        private final TextView dateLabel;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            nameLabel = itemView.findViewById(R.id.row_label_name);
            dateLabel = itemView.findViewById(R.id.row_label_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Snackbar.make(v, R.string.snackbar_action_click, Snackbar.LENGTH_SHORT).show();
        }
    }
}
