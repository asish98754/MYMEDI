package com.example.mymedi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String CHANNEL_ID="SAMPLE_CHANNEL";



    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationId= intent.getIntExtra("notificationId",0);
        String message= intent.getStringExtra("MESSAGE");


        Intent i= new Intent(context,AddMedicine.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent contentInetnt= PendingIntent.getActivity(context,0,i,0);




        NotificationManager myNotificationManager=
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence channel_name= " My Notification";
            int importace = NotificationManager.IMPORTANCE_DEFAULT;


            NotificationChannel channel =new NotificationChannel(CHANNEL_ID,channel_name,importace);
            myNotificationManager.createNotificationChannel(channel);



        }



        NotificationCompat.Builder builder= new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info)

                .setContentTitle("IT'S TIME for MEDICATION -:)")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentInetnt)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL);

        myNotificationManager.notify(notificationId,builder.build());


        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123,builder.build());




    }
}
