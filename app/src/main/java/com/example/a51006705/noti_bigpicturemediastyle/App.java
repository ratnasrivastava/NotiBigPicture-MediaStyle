package com.example.a51006705.noti_bigpicturemediastyle;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by 51006705 on 04-06-2019.
 */

public class App extends Application {

    public static final String CHANNEL_1_ID = "Channel1";
    public static final String CHANNEL_2_ID = "Channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1 = new NotificationChannel(CHANNEL_1_ID, "Channel1", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel1.setDescription("This is Channel1");

            NotificationChannel notificationChannel2 = new NotificationChannel(CHANNEL_2_ID, "Channel2", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel2.setDescription("This is Channel2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(notificationChannel1);
            notificationManager.createNotificationChannel(notificationChannel2);
        }

    }
}
