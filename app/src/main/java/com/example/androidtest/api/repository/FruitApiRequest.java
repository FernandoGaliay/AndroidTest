package com.example.androidtest.api.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.api.service.FruitService;
import com.example.androidtest.data.FruitDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitApiRequest {

    public static void requestFruits(MutableLiveData<List<FruitDTO>> fruitsLiveData) {

        FruitService.create().getFriuts(FruitService.CATEGORY_FRUIT, 1, 10).enqueue(new Callback<List<FruitDTO>>() {
            @Override
            public void onResponse(Call<List<FruitDTO>> call, Response<List<FruitDTO>> response) {
                fruitsLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<FruitDTO>> call, Throwable t) {
                // Todo
            }
        });
    }
}
