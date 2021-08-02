package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class detailbill extends AppCompatActivity {

    private Button btnfinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbill);

        btnfinish = findViewById(R.id.btnfinish);


        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detailbill.this, restoranku.class);
                startActivity(intent);
            }
        });
    }
}