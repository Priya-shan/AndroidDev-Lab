package com.example.calculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class bill_generator extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_generator);
        CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox)findViewById(R.id.checkBox4);
        RadioGroup rg=(RadioGroup)findViewById(R.id.mode);

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int price=0;
                int count=0;
                if(cb1.isChecked()){
                    final TextView item1=findViewById(R.id.item1);
                    count=Integer.parseInt(item1.getText().toString());
                    price+=(count*5);
                }
                if(cb2.isChecked()){
                    final TextView item2=findViewById(R.id.item2);
                    count=Integer.parseInt(item2.getText().toString());
                    price+=(count*15);
                }
                if(cb3.isChecked()){
                    final TextView item3=findViewById(R.id.item3);
                    count=Integer.parseInt(item3.getText().toString());
                    price+=(count*10);
                }
                if(cb4.isChecked()){
                    final TextView item4=findViewById(R.id.item4);
                    count=Integer.parseInt(item4.getText().toString());
                    price+=(count*30);
                }
                if(count==0){
                    Toast.makeText(getApplicationContext(), "Please select atleast one item to place order", Toast.LENGTH_SHORT).show();
                }
                else if(rg.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one payment method to proceed further", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // get selected radio button from radioGroup
                    int selectedId = rg.getCheckedRadioButtonId();
                    // find the radiobutton by returned id
                    RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);
                    Toast.makeText(getApplicationContext(), selectedRadioButton.getText().toString()+" is selected Payment Mode. Total amount to be paid is Rs."+price+"", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button b1 = findViewById(R.id.prev3);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),count_vowels.class);
                startActivity(i);
                setContentView(R.layout.count_vowels);
            }
        });
        Button b2 = findViewById(R.id.next3);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(),notification.class);
                startActivity(i3);
                setContentView(R.layout.notification);
            }
        });


}}
