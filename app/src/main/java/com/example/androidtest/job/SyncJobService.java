package com.example.androidtest.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.arch.lifecycle.Observer;
import android.os.Build;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;
import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.data.dbo.CountryUtil;
import com.example.androidtest.data.repository.country.CountryRepository;
import com.example.androidtest.data.repository.fruit.FruitDataSource;
import com.example.androidtest.data.repository.fruit.FruitRepository;

import java.util.ArrayList;
import java.util.List;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SyncJobService extends JobService {

    private FruitQueryBo query;

    private FruitRepository fruitRepository;

    private CountryRepository countryRepository;

    private Observer<List<CountryDbo>> observer;

    public SyncJobService() {

        query = new FruitQueryBo();
        fruitRepository = new FruitRepository();
        countryRepository = new CountryRepository();

    }

    @Override
    public boolean onStartJob(JobParameters params) {

        observer = countryDboList -> {
            assert countryDboList != null;
            requestFruits(params, countryDboList.get(0)); // After country table is initialized, request fuits
        };
        initializeCountryTable(observer);
        return true;

    }

    private void initializeCountryTable(Observer<List<CountryDbo>> observer) {

        countryRepository.getCountryies().observeForever(observer);
        countryRepository.setData(CountryUtil.getCountries());

    }

    private void requestFruits(JobParameters params, CountryDbo defaultCountry) {

        fruitRepository.getFruitPaging(query.getLimit(), query.getOffset(), new FruitDataSource.Callback<List<FruitBo>>() {

            @Override
            public void onSuccess(List<FruitBo> data) {

                if (data == null || query.getOffset() > data.size()) {

                    countryRepository.getCountryies().removeObserver(observer);
                    jobFinished(params, false);

                } else {

                    List<FruitBo> fruitWithCountryList = new ArrayList<>();

                    for (FruitBo fruit : data) {

                        fruit.setCountryId(defaultCountry.getId());
                        fruitWithCountryList.add(fruit);

                    }

                    fruitRepository.setData(fruitWithCountryList);
                    query.nextQuery();
                    requestFruits(params, defaultCountry);

                }
            }

            @Override
            public void onError(String message) {

                countryRepository.getCountryies().removeObserver(observer);
                jobFinished(params, false);

            }

        });

    }

    @Override
    public boolean onStopJob(JobParameters params) {

        return false;

    }
}
