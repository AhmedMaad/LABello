package com.example.labello.testslibrary;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labello.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TestsLibraryAdapter extends RecyclerView.Adapter<TestsLibraryAdapter.MVH> {

    private Activity activity;
    private ArrayList<TestsLibraryModel> models;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onClick(TestsLibraryModel test);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

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
        return new MVH(v, onItemClickListener);
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
        private CardView cardView;

        public MVH(@NonNull @NotNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.iv);
            cardView = itemView.findViewById(R.id.cv);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(models.get(getAdapterPosition()));
                }
            });

        }
    }

}
