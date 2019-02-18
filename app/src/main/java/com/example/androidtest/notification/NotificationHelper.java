package com.example.androidtest.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;

import com.example.androidtest.R;
import com.example.androidtest.TestApplication;
import com.example.androidtest.dashboard.DashboardActivity;
import com.example.androidtest.recycler.ui.RecyclerActivity;

public class NotificationHelper {

    private static final String NOTIFICATION_DEFAULT_CHANNEL_ID = "NOTIFICATION_DEFAULT_CHANNEL_ID";

    private static int NOTIFICATION_ID = 0;

    private static volatile NotificationHelper notificationHelper;

    static NotificationManager notificationManager;

    private NotificationHelper() {
        // Nothing to do
    }

    public synchronized static NotificationHelper getInstance() {
        if (notificationHelper == null) {
            synchronized (NotificationHelper.class) {
                if (notificationHelper == null) {
                    notificationHelper = new NotificationHelper();
                }
            }
        }
        return notificationHelper;
    }

    public void createNotificationChannel() {
        notificationManager = (NotificationManager) TestApplication.getINSTANCE().getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_DEFAULT_CHANNEL_ID,
                    "Test Notifications",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("This is the notification channel for default notifications.");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotification(Context context) {
        NotificationCompat.Builder builder = getNotificationBuilder(context);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void cancelNotification() {
        notificationManager.cancel(NOTIFICATION_ID);
    }

    public void updateNotification(Context context) {
        Bitmap androidImage = BitmapFactory
                .decodeResource(context.getResources(), R.drawable.ic_action_face);
        Intent actionIntent = new Intent(context, RecyclerActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, actionIntent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = getNotificationBuilder(context)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(androidImage))
                .addAction(R.drawable.ic_action_add, context.getResources().getString(R.string.recycler_title), actionPendingIntent);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private NotificationCompat.Builder getNotificationBuilder(Context context) {
        Intent notificationIntent = new Intent(context, DashboardActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        return new NotificationCompat.Builder(context, NOTIFICATION_DEFAULT_CHANNEL_ID).
                setContentTitle(context.getResources().getString(R.string.notification_title))
                .setContentText(context.getResources().getString(R.string.notification_description))
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
    }
}
