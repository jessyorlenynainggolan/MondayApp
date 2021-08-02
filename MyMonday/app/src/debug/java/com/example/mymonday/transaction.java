package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class transaction extends AppCompatActivity {

    private Button btnok0,btnok1,btnok2,btnok3,btnok4,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        btnok0 = findViewById(R.id.confirm0);
        btnok0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, Successfull.class);
                startActivity(intent);
                finish();
            }
        });
        btnok1 = findViewById(R.id.confirm1);
        btnok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, Successfull.class);
                startActivity(intent);
                finish();
            }
        });
        btnok2 = findViewById(R.id.confirm2);
        btnok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, Successfull.class);
                startActivity(intent);
                finish();
            }
        });
        btnok3 = findViewById(R.id.confirm3);
        btnok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, Successfull.class);
                startActivity(intent);
                finish();
            }
        });
        btnok4 = findViewById(R.id.confirm4);
        btnok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, Successfull.class);
                startActivity(intent);
                finish();
            }
        });
        btnback = findViewById(R.id.back3);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaction.this, menuresto.class);
                startActivity(intent);
                finish();
            }
        });
    }
}