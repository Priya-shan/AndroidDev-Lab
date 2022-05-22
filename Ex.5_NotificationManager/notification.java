package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;

public class notification extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        Button b= findViewById(R.id.n1);
        b.setOnClickListener(v -> {

            Intent intent = new Intent(notification.this.getApplicationContext(), notifyy.class);
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pending = PendingIntent.getActivity(notification.this.getApplicationContext(), 0, intent, 0);
            Notification notify = new Notification.Builder
                    (notification.this.getApplicationContext()).setContentTitle("tittle").setContentText("body").setSmallIcon(R.drawable.abc).setContentIntent(pending).build();
            NotificationManager nm = (NotificationManager) notification.this.getSystemService(Context.NOTIFICATION_SERVICE);
            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            nm.notify(0, notify);
        });
        Button b1 = findViewById(R.id.prev4);
        b1.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),bill_generator.class);
            startActivity(i);
            setContentView(R.layout.bill_generator);
        });
    }

}
