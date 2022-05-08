package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra( "value");

        int intvalue = Integer.valueOf(buttonvalue);

        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_bow2);
                break;

            case 2:
                setContentView(R.layout.activity_bridge2);
                break;

            case 3:
                setContentView(R.layout.activity_chair2);
                break;

            case 4:
                setContentView(R.layout.activity_child2);
                break;

            case 5:
                setContentView(R.layout.activity_cobbler2);
                break;

            case 6:
                setContentView(R.layout.activity_cow2);
                break;

            case 7:
                setContentView(R.layout.activity_playji2);
                break;

            case 8:
                setContentView(R.layout.activity_pauseji2);
                break;

            case 9:
                setContentView(R.layout.activity_plank2);
                break;

            case 10:
                setContentView(R.layout.activity_crunches2);
                break;

            case 11:
                setContentView(R.layout.activity_situp2);
                break;

            case 12:
                setContentView(R.layout.activity_rotation2);
                break;

            case 13:
                setContentView(R.layout.activity_twist2);
                break;

            case 14:
                setContentView(R.layout.activity_windmill2);
                break;

            case 15:
                setContentView(R.layout.activity_legup2);
                break;
        }

        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MTimeRunning){

                    stoptimer();

                }
                else {

                    startTimer();

                }
            }
        });

    }

    private void stoptimer(){
        countDownTimer.cancel();
        MTimeRunning=false;
        startBtn.setText("START");
    }

    private void startTimer(){
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        MTimeLeftinmillis = number * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftinmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                MTimeLeftinmillis = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {

                int newvalue = Integer.valueOf(buttonvalue) + 1;
                if (newvalue<=7){
                    Intent intent = new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else{
                    newvalue = 1;
                    Intent intent = new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunning = true;

    }

    private void updateTimer(){
        int minutes = (int) MTimeLeftinmillis/60000;
        int seconds = (int) MTimeLeftinmillis%60000 / 1000;

        String timeLeftText = "";
        if (minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}