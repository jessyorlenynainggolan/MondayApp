package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class restorant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restorant);

        Button buttondetail=(Button) findViewById(R.id.buttondetail);
        Button buttondetail1=(Button) findViewById(R.id.buttondetail1);
        Button buttonback=(Button) findViewById(R.id.back);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback=new Intent(restorant.this,restoranku.class);
                startActivity(intentback);
            }
        });

        buttondetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdetail=new Intent(restorant.this,restodetail.class);
                startActivity(intentdetail);
            }
        });
        buttondetail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdetail1=new Intent(restorant.this,restodetail.class);
                startActivity(intentdetail1);
            }
        });

    }
}