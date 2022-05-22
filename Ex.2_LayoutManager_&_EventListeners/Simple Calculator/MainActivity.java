package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText num1=findViewById(R.id.num1);
        final EditText num2=findViewById(R.id.num2);

        final TextView res=findViewById(R.id.res);

        Button b1=findViewById(R.id.add);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());

                res.setText(Integer.toString(a+b));
            }
        });

        Button b2=findViewById(R.id.sub);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());

                res.setText(Integer.toString(a-b));
            }
        });

        Button b3=findViewById(R.id.mul);
        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());

                res.setText(Integer.toString(a*b));
            }
        });

        Button b4=findViewById(R.id.div);
        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());

                res.setText(Integer.toString(a/b));
            }
        });

        Button b5=findViewById(R.id.next1);
        b5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),count_vowels.class);
                startActivity(i);
                setContentView(R.layout.count_vowels);
            }
        });
    }

}