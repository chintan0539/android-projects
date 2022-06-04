package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button goButton;
    Button playAgain;
    TextView sumTextView;
    TextView timerTextView;
    TextView scoreTextView;
    TextView resultTextView;
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuestions=0;
    ArrayList<Integer> answer=new ArrayList<Integer>();
    ConstraintLayout gameLayout;



    public void playAgain(View view) {
        score=0;
        numberOfQuestions=0;
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQue();
        playAgain.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("DONE!");
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void chooseAnswer(View view){
       if( Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            resultTextView.setText("CORRECT!");
            score++;
       }else{
           resultTextView.setText("Wrong :(");

       }
       numberOfQuestions++;
       scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQue();

    }


    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.scoreTextView));
        gameLayout.setVisibility(View.VISIBLE);


    }


    public void newQue(){
        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationOfCorrectAnswer=rand.nextInt(4);
        answer.clear();
        for(int i=0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answer.add(a+b);
            }else {
                int wrongAnswer=rand.nextInt(42);
                while(wrongAnswer==a+b){
                    wrongAnswer=rand.nextInt(41);
                }
                answer.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);
        resultTextView=findViewById(R.id.resultTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        timerTextView=findViewById(R.id.timerTextView);
        playAgain=findViewById(R.id.playAgain);

         sumTextView=findViewById(R.id.sumTextView);
        goButton=findViewById(R.id.goButton);
        goButton.setVisibility(View.VISIBLE);

        gameLayout=findViewById(R.id.gameLayout);
        gameLayout.setVisibility(View.INVISIBLE);




    }
}