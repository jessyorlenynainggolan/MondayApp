package com.example.mymonday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class historyorder extends AppCompatActivity {

    // Iniatialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyorder);

        Button buttondetail=(Button) findViewById(R.id.buttondetail);

        buttondetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenthistori=new Intent(historyorder.this,detailbill.class);
                startActivity(intenthistori);
            }
        });
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu (View view) {
        //Open drawer
        restoranku.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        //Close drawer
        restoranku.closeDrawer(drawerLayout);
    }

    public void ClickHome (View view) {
        //Redirect activity to home
        restoranku.redirectActivity(this, restoranku.class);
    }

    public void ClickProfile (View view) {
        //Redirect activity to profile
        restoranku.redirectActivity(this,userprofile.class);
    }

    public void ClickHistory (View view) {
        //Recreate activity
        recreate();

    }

    public void ClickLogout (View view) {
        //Close app
        restoranku.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        restoranku.closeDrawer(drawerLayout);
    }
}