package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class viewbill extends AppCompatActivity {

    private Button buttonsukses,btnback,btncashless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbill);

        TextView text = findViewById(R.id.berhasil);
        TextView total1 = findViewById(R.id.total);
        TextView disc = findViewById(R.id.diskon);
        TextView bel = findViewById(R.id.totalbelanja);
        Intent intent = getIntent();
        String sum = intent.getStringExtra("Try");

        int tot = intent.getIntExtra("Pay",0);
        int discount = intent.getIntExtra("Discount",0);
        int belanja = tot - discount;
        text.setText(sum);
        total1.setText("Rp. "+ tot);
        disc.setText("Rp. "+discount);
        bel.setText("Rp. "+belanja);

        buttonsukses = findViewById(R.id.btncash);

        buttonsukses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(viewbill.this, Successfull.class);
                startActivity(intent1);
                finish();
            }
        });
        btncashless = findViewById(R.id.btncashless);

        btncashless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewbill.this, transaction.class);
                startActivity(intent);
                finish();
            }
        });
        btnback = findViewById(R.id.back3);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewbill.this, menuresto.class);
                startActivity(intent);
                finish();
            }
        });

    }
}