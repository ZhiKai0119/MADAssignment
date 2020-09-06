package com.example.madassignment.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;

public class CartViewHolder extends RecyclerView.ViewHolder {

    public TextView cartProductID, cartName, cartPrice, cartQuantity;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        cartProductID = itemView.findViewById(R.id.product_id);
        cartName = itemView.findViewById(R.id.item_name);
        cartPrice = itemView.findViewById(R.id.item_price);
        cartQuantity = itemView.findViewById(R.id.quantity);
    }
}
