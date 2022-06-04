package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=(SharedPreferences) this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);

//        ArrayList<String> friends=new ArrayList<String>();
//        friends.add("Shubham");
//        friends.add("kala");
//        friends.add("Raj");
//
//
//        try {
//            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
//            Log.i("Friends",ObjectSerializer.serialize(friends));
//        } catch (Exception e) {
//            e.printStackTrace();
//        };

        ArrayList<String> newFriends=new ArrayList<String>();
        try {
            newFriends=(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>() )));
            Log.i("NEWWWWWWW FRND",newFriends.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //        sharedPreferences.edit().putString("userName","Chintan").apply();

//
//       String userName= sharedPreferences.getString("userName","xyz");
//
//        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

    }
}