package com.example.androidtest.api.repository;

import android.util.Log;

import com.example.androidtest.api.service.FruitService;
import com.example.androidtest.data.bo.FruitBO;
import com.example.androidtest.data.dto.FruitDTO;
import com.example.androidtest.data.mapper.FruitMapper;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class FruitApiDataSource extends FruitDataSource<FruitBO> {

    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBO>> callback) {

        FruitService.create().getFruits(FruitService.CATEGORY_FRUIT, limit, offset).enqueue(new retrofit2.Callback<List<FruitDTO>>() {

            @Override
            public void onResponse(Call<List<FruitDTO>> call, Response<List<FruitDTO>> response) {

                callback.onSuccess(FruitMapper.dtoToBO(response.body()));

            }

            @Override
            public void onFailure(Call<List<FruitDTO>> call, Throwable t) {

                callback.onError(t.getMessage());

            }
        });

    }

    @Override
    public List<FruitBO> getData(int limit, int offset) {

        try {

            Response<List<FruitDTO>> response = FruitService.create().getFruits(FruitService.CATEGORY_FRUIT, limit, offset).execute();

            if (response.isSuccessful()) {

                return FruitMapper.dtoToBO(response.body());

            } else {

                return null;

            }

        } catch (IOException e) {

            Log.e(getClass().getSimpleName(), e.getMessage());
            return null;

        }

    }
}
