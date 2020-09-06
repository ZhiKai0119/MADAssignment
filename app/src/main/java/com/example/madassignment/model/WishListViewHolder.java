package com.example.madassignment.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;

public class WishListViewHolder extends RecyclerView.ViewHolder {

    public TextView wishId, wishName, wishPrice;

    public WishListViewHolder(@NonNull View itemView) {
        super(itemView);

        wishId = itemView.findViewById(R.id.product_id);
        wishName = itemView.findViewById(R.id.product_name);
        wishPrice = itemView.findViewById(R.id.product_price);
    }
}
