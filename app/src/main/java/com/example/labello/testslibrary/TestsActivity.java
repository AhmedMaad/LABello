package com.example.labello.testslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.labello.R;

import java.util.ArrayList;

public class TestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        ArrayList<TestsLibraryModel> models = new ArrayList<>();
        models.add(new TestsLibraryModel("Complete Blood Cell (CBD)", R.drawable.cbc));
        models.add(new TestsLibraryModel("Hemoglobin (A1c)", R.drawable.hemoglobin));
        models.add(new TestsLibraryModel("Liver Function Test (LFT)", R.drawable.liver));
        models.add(new TestsLibraryModel("Creatinine Clearance (CC)", R.drawable.creatinine));
        models.add(new TestsLibraryModel("Antigen (AG)", R.drawable.antigen));
        models.add(new TestsLibraryModel("Heart Test (HT)", R.drawable.heart));
        models.add(new TestsLibraryModel("Cardiac Test (ECG)", R.drawable.cardiac));
        models.add(new TestsLibraryModel("Urine Test (UT)", R.drawable.urine));
        models.add(new TestsLibraryModel("Blood & Urine Test (BUT)", R.drawable.blood_urine));
        models.add(new TestsLibraryModel("Fast Blood Glucode Level", R.drawable.glucose));

        TestsLibraryAdapter adapter = new TestsLibraryAdapter(this, models);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(adapter);

    }

}