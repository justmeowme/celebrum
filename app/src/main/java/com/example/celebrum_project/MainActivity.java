package com.example.celebrum_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread simpleTimer = new Thread(){
            public void run(){
                try{
                    int logoTimer = 0;
                    while(logoTimer<2000){
                        sleep(100);
                        logoTimer+=100;
                    };
                    Intent intent = new Intent(MainActivity.this, EnterActivity.class);
                    startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        simpleTimer.start();
    }
}
