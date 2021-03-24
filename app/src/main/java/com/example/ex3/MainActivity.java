package com.example.ex3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context myContext;
    Toast myToast;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = getApplicationContext();
        myToast = new Toast(myContext);
        myToast.makeText(myContext, "hello", Toast.LENGTH_LONG ).show();

        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("This is a neutral dialog");
        dialogConf.setMessage("Text of dialog");
        dialogConf.setIcon(R.mipmap.ic_launcher);

        dialogConf.setNeutralButton("Dismis",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myToast.makeText(myContext, "you cliked dismis", Toast.LENGTH_LONG).show();
                    }
                });
        dialogConf.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myToast.makeText(myContext, "you cliked yes", Toast.LENGTH_LONG).show();
                    }
                });

        dialogConf.setNegativeButton("no",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myToast.makeText(myContext, "you cliked no", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog myDialog = dialogConf.create();
        myDialog.show();

        Notification.Builder notifConf = new Notification.Builder(this);
        notifConf.setContentTitle("this a notification");
        notifConf.setContentText("this is the detail");
        notifConf.setSmallIcon(R.mipmap.ic_launcher);

        Intent myIntent = new Intent(this, childActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(myContext,0, myIntent,0);
        notifConf.setContentIntent(contentIntent);

        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(12345,notifConf.build());


    }
}