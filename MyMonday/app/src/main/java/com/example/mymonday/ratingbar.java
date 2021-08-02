package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ratingbar extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnSubmit;
    EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        ratingBar = findViewById(R.id.rating);
        btnSubmit = findViewById(R.id.btnsubmit);
        comment = findViewById(R.id.comment);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),s+"Star",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ratingbar.this, historyorder.class);
                startActivity(intent);
            }
        });

    }
}