package com.example.labello.testsresult;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labello.R;
import com.example.labello.patient.PatientModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TestsResultAdapter extends RecyclerView.Adapter<TestsResultAdapter.MVH> {

    private Activity activity;
    private ArrayList<PatientModel> patients;

    public TestsResultAdapter(Activity activity, ArrayList<PatientModel> patients) {
        this.activity = activity;
        this.patients = patients;
    }

    @NonNull
    @NotNull
    @Override
    public TestsResultAdapter.MVH onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = activity.getLayoutInflater()
                .inflate(R.layout.tests_result_list_item, parent, false);
        return new MVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TestsResultAdapter.MVH holder, int position) {
        holder.textView.setText(
                patients.get(position).getfName() + " " +
                        patients.get(position).getmName() + " " +
                        patients.get(position).getsName()
        );
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public class MVH extends RecyclerView.ViewHolder {

        private TextView textView;

        public MVH(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }

}
