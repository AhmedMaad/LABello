package com.example.labello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;

import com.example.labello.offers.OffersActivity;
import com.example.labello.patient.PatientActivity;
import com.example.labello.profile.ProfileActivity;
import com.example.labello.registeration.LoginActivity;
import com.example.labello.testslibrary.TestsActivity;
import com.example.labello.testsresult.TestsResultActivity;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    ImageButton btnotify;
    ImageButton btnprof;
    ImageButton btnoffer;
    ImageButton btnlib;
    ImageButton btnres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnprof = findViewById(R.id.profile);
        btnotify = findViewById(R.id.notificationimg);
        btnoffer = findViewById(R.id.offersimg);
        btnlib = findViewById(R.id.testlibraryimg);
        btnres = findViewById(R.id.testresultsimg);

        if (firebaseAuth.getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void openTestsLibrary(View view) {
        Intent i = new Intent(this, TestsActivity.class);
        startActivity(i);
    }

    public void openOffersActivity(View view) {
        Intent i = new Intent(this, OffersActivity.class);
        startActivity(i);
    }

    public void openProfileActivity(View view) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }


    public void openTestsResult(View view) {
        Intent i = new Intent(this, TestsResultActivity.class);
        startActivity(i);
    }

}