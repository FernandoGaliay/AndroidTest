package com.example.androidtest.api.service;

import com.example.androidtest.api.ApiClient;
import com.example.androidtest.data.dto.FruitDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FruitService {

    String CATEGORY_FRUIT = "Fruit";

    static FruitService create() {
        return ApiClient.getClient().create(FruitService.class);
    }

    @GET("resource/hma6-9xbg.json")
    Call<List<FruitDto>> getFruits(@Query("category") String category, @Query("$limit") int limit, @Query("$offset") int offset);

}
