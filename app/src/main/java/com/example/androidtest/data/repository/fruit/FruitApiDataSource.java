package com.example.androidtest.data.repository.fruit;

import android.util.Log;

import com.example.androidtest.api.service.FruitService;
import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.dto.FruitDto;
import com.example.androidtest.data.mapper.FruitMapper;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class FruitApiDataSource extends FruitDataSource<FruitBo> {

    @Override
    public void getAsyncData(int limit, int offset, Callback<List<FruitBo>> callback) {

        FruitService.create().getFruits(FruitService.CATEGORY_FRUIT, limit, offset).enqueue(new retrofit2.Callback<List<FruitDto>>() {

            @Override
            public void onResponse(Call<List<FruitDto>> call, Response<List<FruitDto>> response) {

                callback.onSuccess(FruitMapper.dtoToBo(response.body()));

            }

            @Override
            public void onFailure(Call<List<FruitDto>> call, Throwable t) {

                callback.onError(t.getMessage());

            }
        });

    }

    @Override
    public List<FruitBo> getData(int limit, int offset) {

        try {

            Response<List<FruitDto>> response = FruitService.create().getFruits(FruitService.CATEGORY_FRUIT, limit, offset).execute();

            if (response.isSuccessful()) {

                return FruitMapper.dtoToBo(response.body());

            } else {

                return null;

            }

        } catch (IOException e) {

            Log.e(getClass().getSimpleName(), e.getMessage());
            return null;

        }

    }
}
