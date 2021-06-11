package com.example.labello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PatientActivity extends AppCompatActivity {
    private static String pF_name;
    private String pM_name;
    private String pS_name;
    private String pID;
    private Integer p_phnum = 0;
    private String med_disc;
    private String city, st_name, st2_name, appar_num, floornum, bldnum, mainst, region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
    }
}