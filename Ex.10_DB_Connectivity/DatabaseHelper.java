package com.example.db_connectivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Studdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Studdetails(name TEXT primary key,dept TEXT,sid TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Studdetails");

    }
    public Boolean insertuserdata(String name, String dept,String sid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("dept",dept);
        contentValues.put("sid",sid);
        long result=db.insert("Studdetails",null,contentValues);
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
    public Boolean updateuserdata(String name,String dept,String sid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("dept",dept);
        contentValues.put("sid",sid);
        Cursor cursor=db.rawQuery("Select * from Studdetails where name=?",new String[] {name});
        if(cursor.getCount()>0) {


            long result = db.update("Studdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public Boolean deletedata(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Studdetails where name=?",new String[] {name});
        if(cursor.getCount()>0) {


            long result = db.delete("Studdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Studdetails", null);
        return cursor;
    }
}