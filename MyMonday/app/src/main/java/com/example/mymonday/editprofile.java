package com.example.mymonday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class editprofile extends AppCompatActivity {

    private DatabaseReference DBConnect;
    private StorageReference STConnect;
    private String userId, storageUrl;


    ImageView imgprofile;
    EditText name,email,phone,password;
    Button btnsave,btnback;

    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        imgprofile = findViewById(R.id.imgprofile);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);

        //Button Save
        btnsave = findViewById(R.id.btnsave);

        DBConnect = FirebaseDatabase.getInstance().getReference("Id");
        STConnect = FirebaseStorage.getInstance().getReference();
        userId = DBConnect.push().getKey();

        btnback = findViewById(R.id.back1);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(editprofile.this, userprofile.class);
                startActivity(intent);
                finish();
            }
        });

        imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGallery();
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImg();
            }
        });
    }


    private void uploadImg() {
        if (filePath != null) {
            String imgname = email.getText().toString();

            final StorageReference ref = STConnect.child("images/"+imgname);
            UploadTask uploadTask = ref.putFile(filePath);
            Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()){
                        throw task.getException();
                    }
                    //Program will continue to get the URL from images
                    return ref.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUrl = task.getResult();
                        storageUrl = downloadUrl.toString();
                        saveData();
                        Toast.makeText(getApplicationContext(),"Data Has Been Saved Successfully",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            });
        }
    }

    private void saveData() {
        User id = new User(userId,
                name.getText().toString(),
                email.getText().toString(),
                phone.getText().toString(),
                password.getText().toString(),
                storageUrl);

        DBConnect.child(userId).setValue(id);
    }

    private void showGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();

            Picasso.get().load(filePath).fit().into(imgprofile);
        } else {
            Toast.makeText(getApplicationContext(), "No File Selected", Toast.LENGTH_SHORT).show();
        }
    }
}