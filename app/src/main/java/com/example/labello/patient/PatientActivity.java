package com.example.labello.patient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.labello.R;
import com.example.labello.branch.BranchModel;
import com.example.labello.branch.MapsActivity;
import com.example.labello.utils.Constants;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

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
    private String chosenBranch;
    private ArrayList<BranchModel> sortedBranches = new ArrayList<>();

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
            //sort branches according to nearest
            sortBranches();
        }
    }

    private void sortBranches() {

        ArrayList<BranchModel> branches = new ArrayList<>();
        branches.add(new BranchModel(29.9602, 31.2569, "Maadi"));
        branches.add(new BranchModel(30.0395, 31.2025, "Dokki"));
        branches.add(new BranchModel(29.8403, 31.2982, "Helwan"));
        branches.add(new BranchModel(30.0131, 31.2089, "Giza"));
        branches.add(new BranchModel(30.0511, 31.2126, "Agouza"));

        Location chosenLocation = new Location(LocationManager.GPS_PROVIDER);
        chosenLocation.setLatitude(lat);
        chosenLocation.setLongitude(lon);
        sortedBranches.clear();
        //Calculating all distances in meters based on selected user location
        for (int i = 0; i < branches.size(); ++i) {
            Location branchLocation = new Location(LocationManager.GPS_PROVIDER);
            branchLocation.setLatitude(branches.get(i).getLatitude());
            branchLocation.setLongitude(branches.get(i).getLongitude());
            float calculatedDistance = chosenLocation.distanceTo(branchLocation);
            sortedBranches.add(new BranchModel(branches.get(i).getName(), calculatedDistance));
        }
        Collections.sort(sortedBranches);
        showSpinner();
    }

    private void showSpinner() {

        Spinner locationSpinner = findViewById(R.id.spinner);
        locationSpinner.setVisibility(View.VISIBLE);

        ArrayList<String> names = new ArrayList<>();
        for (BranchModel x : sortedBranches)
            names.add(x.getName());

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        locationSpinner.setAdapter(adapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosenBranch = names.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
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

        String fName = etFirst.getText().toString();
        String mName = etMiddle.getText().toString();
        String sName = etSur.getText().toString();
        String phone = etPhone.getText().toString();
        String desc = etDesc.getText().toString();
        int age = Integer.parseInt(etAge.getText().toString());

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        String registerDate = "image: " + day + '-' + month + '-' + year;

        PatientModel patient = new PatientModel(Constants.USER_ID, "", fName
                , mName, sName, phone, desc, age, birthDate, chosenBranch, registerDate);

        FirebaseFirestore.getInstance().collection("patients")
                .add(patient)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        documentReference.update("userID", documentReference.getId())
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(PatientActivity.this
                                                , "Patient Added", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                    }
                });

    }

}