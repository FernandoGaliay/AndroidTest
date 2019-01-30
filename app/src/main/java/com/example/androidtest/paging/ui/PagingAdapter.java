package com.example.androidtest.paging.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.data.bo.FruitBo;

import java.util.ArrayList;
import java.util.List;

public class PagingAdapter extends RecyclerView.Adapter<PagingAdapter.ViewHolder> {

    private List<FruitBo> fruitBoList;

    public PagingAdapter() {

        this.fruitBoList = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recycler_data, viewGroup, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        FruitBo fruit = fruitBoList.get(position);
        viewHolder.nameLabel.setText(fruit.getItem());
        viewHolder.dateLabel.setText(fruit.getCategory());

    }

    @Override
    public int getItemCount() {

        return fruitBoList.size();

    }

    public void addData(List<FruitBo> fruitBoList) {

        if (fruitBoList == null || fruitBoList.isEmpty()) {
            return;
        }

        int indexStart = this.fruitBoList.size();
        int indexEnd = indexStart + fruitBoList.size();
        this.fruitBoList.addAll(fruitBoList);
        notifyItemRangeInserted(indexStart, indexEnd);

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameLabel;
        private final TextView dateLabel;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            nameLabel = itemView.findViewById(R.id.row_label_name);
            dateLabel = itemView.findViewById(R.id.row_label_date);

        }
    }
}
