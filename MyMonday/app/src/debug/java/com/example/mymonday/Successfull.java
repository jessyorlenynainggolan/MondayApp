package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Successfull extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfull);

        final int welcomeScreenDisplay = 2000; // 2000 = 2 detik
        Thread welcomeThread = new Thread() {

            int wait = 0 ;
            @Override
            public void run () {
                try {
                    super.run();
                    while (wait < welcomeScreenDisplay) {
                        sleep (100);
                        wait += 100;
                    }
                } catch (Exception e) {
                    System.out.println("EXc=" + e);
                } finally {
                    Intent intent = new Intent(Successfull.this,ratingbar.class);
                    finish();
                    startActivity(intent);
                }

            }
        };
        welcomeThread.start();
    }
}