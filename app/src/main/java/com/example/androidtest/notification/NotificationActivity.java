package com.example.androidtest.notification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.BaseToolbarActivity;
import com.example.androidtest.R;

public class NotificationActivity extends BaseToolbarActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        context.startActivity(intent);
    }

    private Button createButton;
    private Button cancelButton;
    private Button updateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NotificationHelper.getInstance().createNotificationChannel();
        createButton = findViewById(R.id.notification_label_create);
        updateButton = findViewById(R.id.notification_label_update);
        cancelButton = findViewById(R.id.notification_label_dismiss);
        createButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notifications;
    }

    @Override
    protected int getContainerId() {
        return 0;
    }

    //region OnClickListener

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_label_create:
                NotificationHelper.getInstance().createNotification(this);
                break;
            case R.id.notification_label_dismiss:
                NotificationHelper.getInstance().cancelNotification();
                break;
            case R.id.notification_label_update:
                NotificationHelper.getInstance().updateNotification(this);
                break;
            default:
                Log.w(getClass().getSimpleName(), "No action mapped");
        }
    }


    //endregion

}
