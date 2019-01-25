package com.example.androidtest.api.service;

import com.example.androidtest.api.ApiClient;
import com.example.androidtest.data.dto.FruitDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FruitService {

    static final String CATEGORY_FRUIT = "Fruit";

    public static FruitService create() {
        return ApiClient.getClient().create(FruitService.class);
    }

    @GET
    Call<List<FruitDTO>> getFruits(@Query("category") String category, @Query("limit") int limit, @Query("offset") int offset);

}
