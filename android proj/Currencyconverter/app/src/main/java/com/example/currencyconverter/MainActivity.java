package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void  calculate(View view){
        EditText editText=(EditText) findViewById(R.id.editText);
        float a= Float.parseFloat(editText.getText().toString());
        a*=75.43;

        Toast.makeText(this, "Indian INR="+a, Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}