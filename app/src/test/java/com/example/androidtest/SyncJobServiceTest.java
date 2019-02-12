package com.example.androidtest;

import android.app.job.JobParameters;
import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.androidtest.data.bo.FruitBo;
import com.example.androidtest.data.bo.FruitQueryBo;
import com.example.androidtest.data.dbo.CountryDbo;
import com.example.androidtest.data.repository.fruit.FruitDataSource;
import com.example.androidtest.data.repository.fruit.FruitRepository;
import com.example.androidtest.job.SyncJobService;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class SyncJobServiceTest {

    private List<FruitBo> ONE_FRUITS = Lists.newArrayList(new FruitBo());

    private List<FruitBo> TEN_FRUITS = Lists.newArrayList(
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo(),
            new FruitBo());

    private SyncJobService syncJobService;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Mock
    JobParameters jobParameters;
    @Mock
    CountryDbo countryDbo;
    @Mock
    FruitRepository fruitRepository;
    @Mock
    FruitQueryBo fruitQueryBo;

    @Captor
    ArgumentCaptor<FruitDataSource.Callback<List<FruitBo>>> callbackArgumentCaptor;

    @Before
    public void setupSyncJobService() {
        MockitoAnnotations.initMocks(this);
        syncJobService = new SyncJobService();
        syncJobService.setFruitRepository(fruitRepository);
    }

    @Test
    public void requestFruitTestPaging() {
        syncJobService.onStartJob(jobParameters);
        FruitQueryBo fruitQueryBo = new FruitQueryBo();
        Mockito.verify(fruitRepository).getFruitPaging(Matchers.eq(fruitQueryBo.getLimit()), Matchers.eq(fruitQueryBo.getOffset()), callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onSuccess(TEN_FRUITS);
        fruitQueryBo.nextQuery();
        InOrder inOrder = Mockito.inOrder(fruitRepository);
        inOrder.verify(fruitRepository).setData(TEN_FRUITS);
        inOrder.verify(fruitRepository).getFruitPaging(Matchers.eq(fruitQueryBo.getLimit()), Matchers.eq(fruitQueryBo.getOffset()), callbackArgumentCaptor.capture());
    }

    @Test
    public void requestFruitTestFinishJob() {
        syncJobService.onStartJob(jobParameters);
        FruitQueryBo fruitQueryBo = new FruitQueryBo();
        Mockito.verify(fruitRepository).getFruitPaging(Matchers.eq(fruitQueryBo.getLimit()), Matchers.eq(fruitQueryBo.getOffset()), callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onSuccess(ONE_FRUITS);
        Mockito.verify(fruitRepository).setData(ONE_FRUITS);
        Mockito.verifyNoMoreInteractions(fruitRepository);
    }
}
