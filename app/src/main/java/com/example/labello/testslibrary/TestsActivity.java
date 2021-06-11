package com.example.labello.testslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.labello.R;

import java.util.ArrayList;

public class TestsActivity extends AppCompatActivity {

    private ArrayList<TestsLibraryModel> models = new ArrayList<>();
    private ArrayList<TestsLibraryModel> searchList = new ArrayList<>();
    private TestsLibraryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        models.add(new TestsLibraryModel("Complete Blood Cell (CBD)", R.drawable.cbc));
        models.add(new TestsLibraryModel("Hemoglobin (A1c)", R.drawable.hemoglobin));
        models.add(new TestsLibraryModel("Liver Function Test (LFT)", R.drawable.liver));
        models.add(new TestsLibraryModel("Creatinine Clearance (CC)", R.drawable.creatinine));
        models.add(new TestsLibraryModel("Antigen (AG)", R.drawable.antigen));
        models.add(new TestsLibraryModel("Heart Test (HT)", R.drawable.heart));
        models.add(new TestsLibraryModel("Cardiac Test (ECG)", R.drawable.cardiac));
        models.add(new TestsLibraryModel("Urine Analysis Test (UAT)", R.drawable.urine));
        models.add(new TestsLibraryModel("Blood & Urine Test (BUT)", R.drawable.blood_urine));
        models.add(new TestsLibraryModel("Fast Blood Glucose Level", R.drawable.glucose));

        adapter = new TestsLibraryAdapter(this, models);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(adapter);

        EditText searchET = findViewById(R.id.et_search);
        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchList.clear();
                for (TestsLibraryModel test : models) {
                    if (test.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                        searchList.add(test);
                    }
                }
                adapter = new TestsLibraryAdapter(TestsActivity.this, searchList);
                rv.setAdapter(adapter);
            }
        });

    }

}