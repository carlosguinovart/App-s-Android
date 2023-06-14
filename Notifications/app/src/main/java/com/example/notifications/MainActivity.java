package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "MY CHANNEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }



    public void createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String TAG = "TEST Channel";
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    TAG,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);
        }
    }


    public void sendNotification(View view){

    }


    public void createNotification(String arg){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }


}