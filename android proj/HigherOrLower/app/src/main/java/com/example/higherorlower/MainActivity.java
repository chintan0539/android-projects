package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int a;

    public void ran_generator(){

        Random rand = new Random();

        a= rand.nextInt(50);
    }
    public void guess(View view){
        EditText editText=(EditText) findViewById(R.id.editText);
        String b= editText.getText().toString();
        int input=Integer.parseInt(b);

        if(input>a){
            Toast.makeText(this, "Go lower", Toast.LENGTH_SHORT).show();
        }else if(input<a){
           Toast.makeText(this,"go High",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"You got the number congratulations",Toast.LENGTH_LONG).show();
            ran_generator();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ran_generator();

    }
}