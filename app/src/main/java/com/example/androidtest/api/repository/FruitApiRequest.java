package com.example.androidtest.api.repository;

import com.example.androidtest.api.service.FruitService;
import com.example.androidtest.data.dto.FruitDTO;

import java.util.List;

import retrofit2.Callback;

@Deprecated
public class FruitApiRequest {

    public static void requestFruits(int limit, int offset, Callback<List<FruitDTO>> callback) {

        FruitService.create().getFruits(FruitService.CATEGORY_FRUIT, limit, offset).enqueue(callback);
    }
}
