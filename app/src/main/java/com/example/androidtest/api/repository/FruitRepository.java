package com.example.androidtest.api.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.androidtest.api.service.FruitService;
import com.example.androidtest.data.bo.FruitBO;
import com.example.androidtest.data.dto.FruitDTO;
import com.example.androidtest.data.mapper.FruitMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitRepository {

    //region Singletone Instance

    private static FruitRepository fruitRepository;

    public static FruitRepository newInstance() {
        if (fruitRepository == null) {
            fruitRepository = new FruitRepository();
        }
        return fruitRepository;
    }

    private FruitRepository() {
        // Nothing to do
    }

    //endregion

    //region Repository Calls

    private MutableLiveData<List<FruitBO>> fruitsLiveData = new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public LiveData<List<FruitBO>> getFruits(int limit, int offset) {

        if (fruitRepository.fruitsLiveData.getValue() == null) {

            FruitService.create()
                    .getFruits(FruitService.CATEGORY_FRUIT, limit, offset)
                    .enqueue(new Callback<List<FruitDTO>>() {
                        @Override
                        public void onResponse(Call<List<FruitDTO>> call, Response<List<FruitDTO>> response) {
                            fruitsLiveData.setValue(FruitMapper.dtoToBO(response.body()));
                        }

                        @Override
                        public void onFailure(Call<List<FruitDTO>> call, Throwable t) {
                            errorLiveData.setValue(t.getMessage());
                        }
                    });
        }

        return fruitRepository.fruitsLiveData;
    }

    //endregion

}
