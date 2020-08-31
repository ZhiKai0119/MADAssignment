package com.example.madassignment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class WishListAdapter extends FirebaseRecyclerAdapter<WishList, WishListAdapter.viewHolder> {

    public WishListAdapter(@NonNull FirebaseRecyclerOptions<WishList> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull WishListAdapter.viewHolder holder, int position, @NonNull WishList model) {
        holder.name.setText(model.getProduct_Name());
        holder.price.setText(model.getProduct_Price());
    }

    @NonNull
    @Override
    public WishListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_layout, parent, false);
        return new viewHolder(view);
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name, price;

        public viewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
        }
    }
}
