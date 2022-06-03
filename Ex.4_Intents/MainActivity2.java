package com.example.studentdetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity2 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String sfinal = intent.getStringExtra(MainActivity.CGPA);

        String[] arr=sfinal.split(" ");

        TextView dname=findViewById(R.id.dname);
        dname.setText(arr[0]);
        TextView dmail=findViewById(R.id.dmail);
        dmail.setText(arr[1]);
        TextView ddept=findViewById(R.id.ddept);
        ddept.setText(arr[2]);
        TextView dmob=findViewById(R.id.dmob);
        dmob.setText(arr[3]);
    }
}
