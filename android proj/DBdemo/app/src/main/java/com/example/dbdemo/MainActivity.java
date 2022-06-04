package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("Events",MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("createtable if not exists events(name varchar,year int(4))");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}