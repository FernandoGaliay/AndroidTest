package com.example.androidtest;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;
import com.example.androidtest.data.repository.fruit.FruitRepository;
import com.example.androidtest.viewmodel.FruitViewModel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class FruitViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Mock
    private FruitRepository fruitRepository;

    private MutableLiveData<FruitQueryBo> fruitQueryBoMutableLiveData = new MutableLiveData<>();

    private FruitViewModel fruitViewModel;

    @Before
    public void setupFruitViewModel(){
        MockitoAnnotations.initMocks(this);
        fruitViewModel = new FruitViewModel();
        fruitViewModel.setFruitRepository(fruitRepository);
        fruitViewModel.setFruitQuery(fruitQueryBoMutableLiveData);
    }

    @Test
    public void add(){
        fruitViewModel.add();
        Mockito.verify(fruitRepository).setData(Matchers.any(FruitBo.class));
    }

    @Test
    public void nextSearch(){
        FruitQueryBo fruitQueryBo = new FruitQueryBo();
        fruitViewModel.nextFruitSearch();
        assert(fruitQueryBo.equals(fruitQueryBoMutableLiveData.getValue()));
        fruitQueryBo.nextQuery();
        fruitViewModel.nextFruitSearch();
        assert fruitQueryBo.equals(fruitQueryBoMutableLiveData.getValue());
    }
}
