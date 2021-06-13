package com.example.labello.offers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.labello.R;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        ArrayList<OffersModel> offers = new ArrayList<>();
        offers.add(new OffersModel("Complete Blood Cell (CBD)", "150 L.E.", R.drawable.discount_20));
        offers.add(new OffersModel("Blood & Urine Test (BUT)", "3000 L.E.", R.drawable.discount_70));
        offers.add(new OffersModel("Creatinine Clearance (CC)", "1750 L.E.", R.drawable.discount_10));
        offers.add(new OffersModel("Fast Blood Glucode Level", "350 L.E.", R.drawable.discount_20));
        offers.add(new OffersModel("Liver Function Test (LFT)", "4000 L.E.", R.drawable.discount_50));
        offers.add(new OffersModel("Hemoglobin (A1c)", "200 L.E.", R.drawable.discount_50));

        OffersAdapter adapter = new OffersAdapter(this, offers);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setAdapter(adapter);

    }

}