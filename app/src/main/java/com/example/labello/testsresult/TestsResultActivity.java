package com.example.labello.testsresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.labello.R;
import com.example.labello.patient.PatientModel;
import com.example.labello.utils.Constants;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TestsResultActivity extends AppCompatActivity {

    private ArrayList<PatientModel> patients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_result);

        FirebaseFirestore.getInstance()
                .collection("patients")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot snapshots) {
                        List<DocumentSnapshot> documents = snapshots.getDocuments();
                        for (int i = 0; i < documents.size(); ++i) {
                            PatientModel patient = documents.get(i).toObject(PatientModel.class);
                            if (patient.getCustomerID().equals(Constants.USER_ID))
                                patients.add(patient);
                        }
                        RecyclerView rv = findViewById(R.id.rv);
                        TestsResultAdapter adapter = new TestsResultAdapter
                                (TestsResultActivity.this, patients);
                        rv.setAdapter(adapter);
                    }
                });

    }
}