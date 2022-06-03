package com.example.db_connectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        Intent i1=getIntent();
        String valuee=i1.getStringExtra(MainActivity.val);
        tv=findViewById(R.id.textView);
        tv.setText(valuee);

    }
}