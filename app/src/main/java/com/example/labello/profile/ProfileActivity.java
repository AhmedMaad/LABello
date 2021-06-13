package com.example.labello.profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.labello.R;
import com.example.labello.utils.Constants;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {

    private Customer customer;
    private Uri imageUri;
    private FirebaseFirestore db;
    private ImageView profileIV;
    private EditText nameET;
    private TextView mobileTV;
    private TextView emailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileIV = findViewById(R.id.iv_profile);
        nameET = findViewById(R.id.et_name);
        mobileTV = findViewById(R.id.tv_phone);
        emailTV = findViewById(R.id.tv_email);

        db = FirebaseFirestore.getInstance();
        db
                .collection("customer")
                .document(Constants.USER_ID)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        customer = documentSnapshot.toObject(Customer.class);
                        if (!customer.getProfilePicture().isEmpty())
                            Glide.with(ProfileActivity.this)
                                    .load(customer.getProfilePicture()).into(profileIV);
                        if (!customer.getUsername().isEmpty())
                            nameET.setText(customer.getUsername());

                        mobileTV.setText(customer.getPhone());
                        emailTV.setText(customer.getEmail());

                    }
                });
    }

    public void choosePicture(View view) {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            imageUri = data.getData();
            profileIV.setImageURI(imageUri);
        }
    }

    public void updateProfile(View view) {
        if (imageUri != null)
            uploadImage();
        else
            uploadProfile(imageUri); //Image Uri in this case is null
    }

    private void uploadImage() {
        //Accessing Cloud Storage bucket by creating an instance of FirebaseStorage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        //Create a reference to upload, download, or delete a file

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);
        String imageName = "image: " + day + '-' + month + '-' + year + ' ' + hour + ':' + minute
                + ':' + second + '.' + millis;

        StorageReference storageRef = storage.getReference().child(imageName);
        storageRef.putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    getLinkForUploadedImage(storageRef.getDownloadUrl());
                });
    }

    //Getting a download link after uploading a picture
    private void getLinkForUploadedImage(Task<Uri> task) {
        task.addOnSuccessListener(uri -> {
            uploadProfile(uri);
        });
    }

    private void uploadProfile(Uri imageUri) {
        String writtenName = nameET.getText().toString();

        String imageLink;
        if (imageUri != null)
            imageLink = imageUri.toString();
        else
            imageLink = customer.getProfilePicture();

        customer = new Customer(Constants.USER_ID, writtenName, mobileTV.getText().toString()
                , emailTV.getText().toString(), imageLink);

        db
                .collection("customer")
                .document(Constants.USER_ID)
                .set(customer)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ProfileActivity.this, "profile updated"
                                , Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

}