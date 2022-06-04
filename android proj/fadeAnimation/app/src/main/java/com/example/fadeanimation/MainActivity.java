package com.example.fadeanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Boolean a=true;
    ImageView imageView;

    public void fade (View view){
        imageView=(ImageView) findViewById(R.id.imageView);


        imageView.animate().translationXBy(1500).rotation(1800).setDuration(3000);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        imageView.setX(-1500);
        imageView.animate().translationXBy(1500).rotation(1800).setDuration(3000);

    }
}