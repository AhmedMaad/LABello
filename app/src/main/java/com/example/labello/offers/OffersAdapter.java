package com.example.labello.offers;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labello.R;
import com.example.labello.testslibrary.TestsLibraryAdapter;
import com.example.labello.testslibrary.TestsLibraryModel;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MVH> {

    private Activity activity;
    private ArrayList<OffersModel> offers;

    public OffersAdapter(Activity activity, ArrayList<OffersModel> offers) {
        this.activity = activity;
        this.offers = offers;
    }

    @NonNull
    @NotNull
    @Override
    public OffersAdapter.MVH onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v =
                activity.getLayoutInflater().inflate(R.layout.offers_list_item, parent, false);
        return new OffersAdapter.MVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OffersAdapter.MVH holder, int position) {
        holder.name.setText(offers.get(position).getName());
        holder.price.setText(offers.get(position).getPrice());
        holder.discount.setImageResource(offers.get(position).getPicture());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public class MVH extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView price;
        private ImageView discount;

        public MVH(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price_value);
            discount = itemView.findViewById(R.id.discount);
        }
    }

}
