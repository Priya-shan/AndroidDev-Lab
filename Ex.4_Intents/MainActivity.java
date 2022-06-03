package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String CGPA = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                EditText name=findViewById(R.id.name);
                EditText mail=findViewById(R.id.mail);
                EditText dept=findViewById(R.id.dept);
                EditText mobile=findViewById(R.id.mobile);

                String sname=name.getText().toString();
                String smail=mail.getText().toString();
                String sdept=dept.getText().toString();
                String smobile=mobile.getText().toString();

                String sfinal= sname+" "+smail+" "+sdept+" "+smobile;
                intent.putExtra(CGPA, sfinal);
                startActivity(intent);
                setContentView(R.layout.activity_main2);
            }
        });
    }
}