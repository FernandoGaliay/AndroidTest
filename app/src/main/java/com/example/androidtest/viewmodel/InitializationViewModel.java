package com.example.androidtest.viewmodel;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.arch.lifecycle.ViewModel;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

import com.example.androidtest.job.JobIdConstant;
import com.example.androidtest.job.SyncJobService;

public class InitializationViewModel extends ViewModel {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startSync(Context context) {

        JobScheduler jobScheduler =
                (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

        ComponentName componentName = new ComponentName(context, SyncJobService.class);

        JobInfo jobIno = new JobInfo.Builder(JobIdConstant.JOB_SYNC_DATA, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(true)
                .build();

//        jobScheduler.schedule(jobIno);

    }

}
