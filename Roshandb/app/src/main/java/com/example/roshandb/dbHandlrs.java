package com.example.roshandb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHandlrs extends SQLiteOpenHelper {
    public dbHandlrs(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Customerss(name varchar(15),num varchar(15),place varchar(15))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertRecord(String i,String j,String k,){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL();
    }
    public String displayRec(String letter){
        String tdata="";
        Cursor cr;


        SQLiteDatabase db=this.getReadableDatabase();
        cr=db.rawQuery("");
        while(cr.moveToNext()){
            String i=cr.getString(0)
        }
    }
}
