package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class restodetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restodetail);

        Button buttonback=(Button) findViewById(R.id.back1);
        Button buttonmap=(Button) findViewById(R.id.buttonmap);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback=new Intent(restodetail.this,restorant.class);
                startActivity(intentback);
            }
        });
        buttonmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentmap=new Intent(restodetail.this,MapsActivity.class);
                startActivity(intentmap);
            }
        });
    }
}