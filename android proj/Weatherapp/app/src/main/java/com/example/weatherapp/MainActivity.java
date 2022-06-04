package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        textView2=findViewById(R.id.textView2);

    }


    public void getWeather(View view){
        weather task=new weather();
        task.execute("https://openweathermap.org/data/2.5/weather?q="+editText.getText().toString()+"&appid=439d4b804bc8187953eb36d2a8c26a02");

        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editText.getWindowToken(),0);
    }




    public class weather extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";

            URL url;
            HttpURLConnection newConnection=null;
            try {
                url=new URL(urls[0]);
                newConnection=(HttpURLConnection) url.openConnection();
                InputStream in=newConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();

                while(data!=-1){
                    char current=(char)data;
                    result+=current;
                    data=reader.read();
                }
                return result;

            }catch(Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Couldnot find Weather", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject=new JSONObject(s);
                String weatherInfo=jsonObject.getString("weather");
                String weatherInfo2=jsonObject.getString("main");
                Log.i("WEATHER CONTENT",weatherInfo);
                Log.i("WEATHER ",weatherInfo2);
                String message="";
                String msg="";
                JSONArray arr=new JSONArray(weatherInfo);
                for(int i=0;i<arr.length();i++){
                    JSONObject jsonPart=arr.getJSONObject(i);
                    String main,description;
                    main=jsonPart.getString("main");
                    description=jsonPart.getString("description");
                    if(!main.equals("")&& !description.equals("")){
                        message+=main+":"+description+"\r\n";
                    }
                }
                if(!message.equals("")){
                    textView2.setText(message);
                }else{
                    Toast.makeText(getApplicationContext(), "Couldnot find Weather", Toast.LENGTH_SHORT).show();

                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Couldnot find Weather", Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        }
    }
}