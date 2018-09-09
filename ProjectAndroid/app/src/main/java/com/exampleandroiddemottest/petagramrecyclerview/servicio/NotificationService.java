package com.exampleandroiddemottest.petagramrecyclerviewWear.servicio;

//import android.app.Notification;
//import android.app.Notification;
//import android.app.Notification;


import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import android.util.Log;

import com.exampleandroiddemottest.petagramrecyclerviewWear.MainActivity;
import com.exampleandroiddemottest.petagramrecyclerviewWear.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class NotificationService extends FirebaseMessagingService {
    public static final String TAGG ="FIREBASE";
    public static final int NOTIFICATION_ID = 001;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        if (remoteMessage.getNotification() != null) {
            Log.d(TAGG, "Notification Title: " +
                    remoteMessage.getNotification().getTitle());

            Log.d(TAGG , "Notification Message: " +
                    remoteMessage.getNotification().getBody());
        }


        /*Notificacion*/
        //PRIMERA PRUEBA

        //se dirigira algun lado la notifiacion
        Intent i = new Intent(this,MainActivity.class);
        //tipo de datos que recibira la notificacion para dirigirse a nuestro intent.
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        //SONIDO POR DEFECTO DE NOTIFIACION
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action action =
               new NotificationCompat.Action.Builder(R.drawable._curso3,
                        getString(R.string.textopara),pendingIntent)
                .build();

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender();


        //trabajando la notificacion
        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(this,"IDP")
                // .setSmallIcon(R.drawable.bell30)
                .setContentText(remoteMessage.getNotification().getBody())
                .setContentTitle("Vino")
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .extend(wearableExtender.addAction(action))
                //.addAction(R.drawable._curso3,getString(R.string.textopara),pendingIntent)
                ;
        //notifiacion manager sera encargado de mandar la notificacion
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        Notification notification =notificationCompat.build();
        notificationManager.notify(NOTIFICATION_ID,notification);
        /*Notificacion END */

    }


    @Override
    public void onNewToken(String s) {
        // super.onNewToken(s);
        //Log.d("", "Refreshed token: " + token);
        Log.d("tokenFirebase",s);
    }
}
