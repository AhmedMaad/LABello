package com.example.labello.patient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.labello.MapsActivity;
import com.example.labello.R;

public class PatientActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {

    private EditText etFirst;
    private EditText etMiddle;
    private EditText etSur;
    private EditText etPhone;
    private EditText etDesc;
    private EditText etAge;
    private double lat;
    private double lon;
    private String birthDate;

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
        startActivityForResult(i, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Button location = findViewById(R.id.location);
            location.setText("Location Updated");
            lat = data.getDoubleExtra("lat", 0.0);
            lon = data.getDoubleExtra("lon", 0.0);
            Log.d("trace", "Retrieved: " + lat + "," + lon);
        }
    }

    public void chooseBirthdate(View view) {
        DateChooserDialog datePicker = new DateChooserDialog();
        datePicker.setCancelable(false);
        datePicker.show(getSupportFragmentManager(), null);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        birthDate = dayOfMonth + "-" + (month + 1) + "-" + year;
        Button bd = findViewById(R.id.bd);
        bd.setText(birthDate);
    }

    public void addPatient(View view) {
    }

    //TODO: Calculate register date when uploading to firebase

}