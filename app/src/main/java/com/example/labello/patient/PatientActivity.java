package com.example.labello.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.labello.MapsActivity;
import com.example.labello.R;

public class PatientActivity extends AppCompatActivity {

    private EditText etFirst;
    private EditText etMiddle;
    private EditText etSur;
    private EditText etPhone;
    private EditText etDesc;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        etFirst = findViewById(R.id.et_f_name);
        etMiddle = findViewById(R.id.et_m_name);
        etSur = findViewById(R.id.et_sur_nmae);
        etPhone = findViewById(R.id.et_phone);
        etDesc = findViewById(R.id.et_decription);
        etAge = findViewById(R.id.et_age);

    }

    public void chooseLocation(View view) {
        Intent i = new Intent(this, MapsActivity.class);
        //startActivityForResult(i, 101);
        startActivity(i);
    }

    public void chooseBirthdate(View view) {
    }

    public void addPatient(View view) {
    }

    //TODO: Calcualte register date when uploading to firebase

}