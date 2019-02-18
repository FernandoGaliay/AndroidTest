package com.example.androidtest.data.dbo.util;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.example.androidtest.data.dbo.FruitDbo;

public class FruitDboDiffUtilItemCallback extends DiffUtil.ItemCallback<FruitDbo> {


    @Override
    public boolean areItemsTheSame(@NonNull FruitDbo first, @NonNull FruitDbo second) {

        return first.getId().equals(second.getId());

    }

    @Override
    public boolean areContentsTheSame(@NonNull FruitDbo first, @NonNull FruitDbo second) {
        try {
            return first.getId().equals(second.getId()) &&
                    first.getPhone().equals(second.getPhone()) &&
                    first.getFarmName().equals(second.getFarmName()) &&
                    first.getCategory().equals(second.getCategory()) &&
                    first.getItem().equals(second.getItem());
        } catch (Exception e) {
            return false;
        }
    }

}