package com.example.db_connectivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String val="";
    EditText sid;
    EditText name;
    EditText dept;
    Button insert;
    Button update;
    Button delete;
    Button view;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        dept = findViewById(R.id.dept);
        sid = findViewById(R.id.sid);

        insert = findViewById(R.id.add);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.display);
        db = new DatabaseHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_ = name.getText().toString();
                String dept_ = dept.getText().toString();
                String sid_ = sid.getText().toString();

                Boolean checkinsertdata = db.insertuserdata(name_, dept_, sid_);
                if (checkinsertdata == true) {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                }
            }

        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_ = name.getText().toString();
                String dept_ = dept.getText().toString();
                String sid_ = sid.getText().toString();

                Boolean checkupdatedata = db.updateuserdata(name_, dept_, sid_);
                if (checkupdatedata == true) {
                    Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Not updated", Toast.LENGTH_LONG).show();
                }
            }

        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_ = name.getText().toString();

                Boolean checkdeletedata = db.deletedata(name_);
                if (checkdeletedata == true) {
                    Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Not deleted", Toast.LENGTH_LONG).show();
                }
            }

        });

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Cursor res = db.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Record exists", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Student Id: " + res.getString(2) + "\n");
                    buffer.append("Name: " + res.getString(0) + "\n");
                    buffer.append("Department: " + res.getString(1) + "\n");

                    buffer.append("-------------------------------------\n");

                }
                Intent i=new Intent(MainActivity.this,ShowData.class);
                i.putExtra(val,buffer.toString());
                startActivity(i);
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();*/
            }

        });
    }
}
