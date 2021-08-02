package com.example.mymonday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    private EditText email, password1;
    private Button buttonlogin;
    private TextView textsign;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.editemail);
        password1 = findViewById(R.id.editpassword);
        buttonlogin = findViewById(R.id.buttonlogin);
        progressDialog = new ProgressDialog(this);
        textsign = findViewById(R.id.textsign);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        textsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsignup = new Intent(login.this, Signin.class);
                startActivity(intentsignup);
                finish();
            }
        });
    }

    private void Login() {
        String editemail = email.getText().toString();
        String editpassword = password1.getText().toString();

        if (editemail.isEmpty()) {
            email.setError("Email Is Required");
            email.requestFocus();
            return;
        } else if (editpassword.isEmpty()) {
            password1.setError("Password Is Required");
            password1.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editemail).matches()) {
            email.setError("Invalid Email");
            email.requestFocus();
        }

        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        mAuth.signInWithEmailAndPassword(editemail, editpassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_LONG).show();
                        Intent intentlogin = new Intent(login.this, restoranku.class);
                        startActivity(intentlogin);
                        finish();
                } else {
                    Toast.makeText(login.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}