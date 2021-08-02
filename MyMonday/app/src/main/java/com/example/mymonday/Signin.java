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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class Signin extends AppCompatActivity {
    private EditText name, emailEt, pass1, phoneid;
    private Button btnsignup;
    private TextView textmember;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.personName);
        emailEt = findViewById(R.id.editEmail);
        phoneid = findViewById(R.id.editPhone);
        pass1 = findViewById(R.id.editPass1);
        btnsignup = findViewById(R.id.buttonsignup);
        textmember = findViewById(R.id.textmember);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        textmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signin.this,login.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void Register(){
        String personName=name.getText().toString();
        String editEmail=emailEt.getText().toString();
        String editPhone=phoneid.getText().toString();
        String editPass1=pass1.getText().toString();

            if(personName.isEmpty()){
                name.setError("Enter Your Name");
                name.requestFocus();
                return;
            }
            else if(editEmail.isEmpty()){
                emailEt.setError("Email is Requered");
                emailEt.requestFocus();
                return;
            }
            else if(editPhone.isEmpty()){
                phoneid.setError("Enter Your Phone Number");
                phoneid.requestFocus();
            }
            else if(editPass1.isEmpty()){
                pass1.setError("Password Is Required");
                pass1.requestFocus();
                return;
            }
            else if(editPass1.length()<8){
                pass1.setError("Password Must Be More Than 8 Characters");
                pass1.requestFocus();
                return;
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(editEmail).matches()){
                emailEt.setError("Invalid Email");
                pass1.requestFocus();
                return;
            }
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
            mAuth.createUserWithEmailAndPassword(editEmail, editPass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        User user = new User(personName, editEmail, editPhone);
                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Signin.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Signin.this, restoranku.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Signin.this, "Sign Up Failed!", Toast.LENGTH_LONG).show();
                                }
                                progressDialog.dismiss();
                            }
                        });
                    }
                }
            });
        }
    }