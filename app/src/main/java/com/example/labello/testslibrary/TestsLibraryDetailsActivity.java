package com.example.labello.testslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.labello.R;
import com.example.labello.patient.PatientActivity;
import com.example.labello.patient.PatientModel;

public class TestsLibraryDetailsActivity extends AppCompatActivity {

    private TestsLibraryModel test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_library_details);

        test = getIntent().getParcelableExtra("details");
        TextView definition = findViewById(R.id.tv_definition);
        TextView prerequisites = findViewById(R.id.tv_prerequisites);
        TextView requiredSamples = findViewById(R.id.tv_samples);
        TextView reportDelivery = findViewById(R.id.tv_delivery);
        TextView why = findViewById(R.id.tv_why_test);

        setTitle(test.getName());
        definition.setText(test.getDefinition());
        prerequisites.setText(test.getPrerequisite());
        requiredSamples.setText(test.getRequiredSample());
        reportDelivery.setText(test.getReportDelivery());
        why.setText(test.getWhyToBeTested());

    }

    public void register(View view) {
        //open patient activity and send test name with intent
        Intent i = new Intent(this, PatientActivity.class);
        i.putExtra("name", test.getName());
        startActivity(i);
    }

}