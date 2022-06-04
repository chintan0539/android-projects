package com.example.alertdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menuactivity,menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.english:
                setLanguage("English");
                return true;
            case R.id.french:
                setLanguage("French");
                return true;
        }
        return true;
    }

    public void setLanguage(String language){

            sharedPreferences.edit().putString("language",language).apply();
            textView.setText(language);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPreferences=this.getSharedPreferences("com.example.alertdialog", Context.MODE_PRIVATE);
        String language=sharedPreferences.getString("language","Error");
        if(language.equals("Error")){

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.btn_star)
                    .setTitle("Language?")
                    .setMessage("Choose your language")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            setLanguage("English");


                        }
                    })
                    .setNegativeButton("French", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            setLanguage("French");

                        }
                    }).show();

        }else{
            textView.setText(language);

        }




    }
}