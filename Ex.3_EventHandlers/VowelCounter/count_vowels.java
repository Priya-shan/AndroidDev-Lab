package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class count_vowels extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_vowels);

        final EditText ip=findViewById(R.id.ip);
        final TextView result=findViewById(R.id.result);

        Button b = findViewById(R.id.count);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String str = ip.getText().toString();
                int cnt=0;
                for(int i=0;i<str.length();i++) {
                    if (isVowel(str.charAt(i))) {
                        cnt = cnt + 1;
                    }
                }
                result.setText(Integer.toString(cnt));
            }
            public boolean isVowel(char ch){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    return true;
                }
                return false;
            }
        });

        Button b1 = findViewById(R.id.prev2);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                setContentView(R.layout.activity_main);
            }
        });

        Button b2 = findViewById(R.id.next2);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),bill_generator.class);
                startActivity(i2);
                setContentView(R.layout.bill_generator);
            }
        });
    }
}
