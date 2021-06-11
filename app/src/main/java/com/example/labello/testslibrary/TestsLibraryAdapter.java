package com.example.labello.testslibrary;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labello.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TestsLibraryAdapter extends RecyclerView.Adapter<TestsLibraryAdapter.MVH> {

    private Activity activity;
    private ArrayList<TestsLibraryModel> models;

    public TestsLibraryAdapter(Activity activity, ArrayList<TestsLibraryModel> models) {
        this.activity = activity;
        this.models = models;
    }

    @NonNull
    @NotNull
    @Override
    public TestsLibraryAdapter.MVH onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v =
                activity.getLayoutInflater().inflate(R.layout.tests_library, parent, false);
        return new MVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TestsLibraryAdapter.MVH holder, int position) {
        holder.textView.setText(models.get(position).getName());
        holder.imageView.setImageResource(models.get(position).getPicture());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MVH extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public MVH(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

}
