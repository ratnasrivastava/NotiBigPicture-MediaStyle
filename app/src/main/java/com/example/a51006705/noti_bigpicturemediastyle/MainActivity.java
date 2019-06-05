package com.example.a51006705.noti_bigpicturemediastyle;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.a51006705.noti_bigpicturemediastyle.App.CHANNEL_1_ID;
import static com.example.a51006705.noti_bigpicturemediastyle.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextTitle;
    EditText mEditTextMessage;

    Button mButtonSendOnChannel1;
    Button mButtonSendOnChannel2;

    Bitmap bitmapImage;

    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        mEditTextTitle = findViewById(R.id.edit_text_title);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        mButtonSendOnChannel1 = findViewById(R.id.button_send_on_channel1);
        mButtonSendOnChannel2 = findViewById(R.id.button_send_on_channel2);

        bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.ic_dog);

        mButtonSendOnChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1();
            }
        });

        mButtonSendOnChannel2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendOnChannel2();
            }
        });
    }

    private void sendOnChannel1() {

        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();



        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(bitmapImage)
                .setStyle(new NotificationCompat.BigPictureStyle()
                .bigLargeIcon(null)
                .bigPicture(bitmapImage))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManagerCompat.notify(1, notification);
    }

    private void sendOnChannel2() {
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_like, "Like", pendingIntent)
                .addAction(R.drawable.ic_favorite, "Favourite", pendingIntent)
                .addAction(R.drawable.ic_play, "Play", pendingIntent)
                .addAction(R.drawable.ic_pause, "Pause", pendingIntent)
                .addAction(R.drawable.ic_dislike, "Dislike", pendingIntent)
                .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1,2,3)
                )
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}
