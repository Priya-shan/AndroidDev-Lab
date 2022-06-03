package com.example.shanmugapriya_alarmclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextClock curtime;
    TimePicker alarmtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curtime=findViewById(R.id.curtime);
        alarmtime=findViewById(R.id.alarmtime);

        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notificcation","My Notificcation",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Timer t=new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(curtime.getText().toString().equals(AlarmTime())){
                    r.play();
                    NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"My Notificcation");
                    builder.setContentTitle("Alarm");
                    builder.setContentText("WakeUp its Time");
                    builder.setSmallIcon(R.drawable.dp1);
                    builder.setAutoCancel(true);
                    NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                    managerCompat.notify(1,builder.build());
                }
                else{
                    r.stop();
                }
            }
        },0,1000);
    }
    public String AlarmTime(){
        Integer hr=alarmtime.getCurrentHour();
        Integer min=alarmtime.getCurrentMinute();

        String crtFormatOfAlarmTime;
        String fmin;
        if(min<10){
            fmin="0".concat(min.toString());
        }
        else{
            fmin=min.toString();
        }

        if(hr>12){
            //hr=hr-12;
            crtFormatOfAlarmTime=hr.toString().concat(":").concat(fmin);

        }
        else{
            crtFormatOfAlarmTime=hr.toString().concat(":").concat(fmin);
        }
        return crtFormatOfAlarmTime;
    }
}