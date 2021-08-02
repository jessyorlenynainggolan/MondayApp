package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.installations.Utils;
import java.util.Objects;

public class menuresto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuresto);

        Button buttonback=(Button) findViewById(R.id.back2);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback=new Intent(menuresto.this,scanqr.class);
                startActivity(intentback);
            }
        });
        //Menu
        final CheckBox pilih = findViewById(R.id.burger);
        final CheckBox spageti = findViewById(R.id.spageti);
        final CheckBox pizza = findViewById(R.id.piza);
        final CheckBox lemon = findViewById(R.id.lemon);
        final CheckBox thai = findViewById(R.id.thai);
        final CheckBox cofe = findViewById(R.id.cofe);

        //Jumlah
        final EditText jmlhburger = findViewById(R.id.txt_ttl1);
        final EditText jmlhspageti = findViewById(R.id.txt_ttl2);
        final EditText jmlhpiza = findViewById(R.id.txt_ttl3);
        final EditText jmlhlemon = findViewById(R.id.txt_ttl4);
        final EditText jmlhthai = findViewById(R.id.txt_ttl5);
        final EditText jmlhcofe = findViewById(R.id.txt_ttl6);

        //Button Order
        Button btn = findViewById(R.id.btnorder);

        //Harga
        final int hrgaburger = 25000;
        final int hrgaspageti = 160000;
        final int hrgapiza = 195000;
        final int hrgalemon = 20000;
        final int hrgathai = 25000;
        final int hrgacofe = 20000;

        btn.setOnClickListener((v) -> {
            String text = "";
            int totOrder = 0;
            int discount = 0;
            if (pilih.isChecked()) {
                String hasil = "Hamburger";
                int jml = Integer.parseInt(String.valueOf(jmlhburger.getText()));
                int cal = jml * hrgaburger;
                text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                totOrder = totOrder + cal;
            }
            if (spageti.isChecked()) {
                String hasil = "Spaghetti Bol";
                int jml = Integer.parseInt(String.valueOf(jmlhspageti.getText()));
                int cal = jml * hrgaspageti;
                text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                totOrder = totOrder + cal;
            }
            if (pizza.isChecked()) {
                String hasil = "Italian Pizza";
                int jml = Integer.parseInt(String.valueOf(jmlhpiza.getText()));
                int cal = jml * hrgapiza;
                text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                totOrder = totOrder + cal;
            }
            if (lemon.isChecked()) {
                String hasil = "Lemon Tea";
                int jml = Integer.parseInt(String.valueOf(jmlhlemon.getText()));
                int cal = jml * hrgalemon;
                text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                totOrder = totOrder + cal;
            }
            if (thai.isChecked()) {
                String hasil = "Thailand Tea";
                int jml = Integer.parseInt(String.valueOf(jmlhthai.getText()));
                int cal = jml * hrgathai;
                text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                totOrder = totOrder + cal;
            }
            if (cofe.isChecked()) {
                String hasil = "Ice Coffe";
                int jml = Integer.parseInt(String.valueOf(jmlhcofe.getText()));
                int cal = jml * hrgacofe;
                text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + cal + "\n\n";
                totOrder = totOrder + cal;
            }
            if (!pilih.isChecked() && !spageti.isChecked() && !pizza.isChecked() && !lemon.isChecked() && !thai.isChecked() && !cofe.isChecked()){
            Toast.makeText(getApplicationContext(), "Choose Your Menu", Toast.LENGTH_SHORT).show();
            return;
            }
            if (totOrder > 250000) {
                discount = 10000;
            }
            Intent intent = new Intent(menuresto.this,viewbill.class);
            intent.putExtra("Try",text);
            intent.putExtra("Pay",totOrder);
            intent.putExtra("Discount",discount);
            startActivity(intent);
        }) ;
    }
}