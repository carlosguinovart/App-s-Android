package com.example.notifications;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


       public void onMessageRecived(@NonNull RemoteMessage message){
           Log.v("carlos", "FROM "+ message.getFrom());
           if (message.getNotification()!=null){
               Log.d("carlos", "message payload "+ message.getData());
               Log.d("carlos", "body "+ message.getNotification().getBody());
           }
           else{
               Log.v("carlos", "ERROR onMessageRecived");
           }
       }


}


