package com.example.showhideuielements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    public void show(View view){
         textView=(TextView) findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);
    }

    public void hide(View view){
        textView=(TextView) findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}