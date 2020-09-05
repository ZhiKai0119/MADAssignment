package com.example.madassignment.model;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;

public class CartViewHolder extends RecyclerView.ViewHolder {

    public TextView cartName, cartPrice, cartQuantity;
    private AdapterView.OnItemClickListener onItemClickListener;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        cartName = itemView.findViewById(R.id.item_name);
        cartPrice = itemView.findViewById(R.id.item_price);
        cartQuantity = itemView.findViewById(R.id.quantity);
    }

//    @Override
//    public void onClick(View view) {
//        onItemClickListener.onItemClick(view, getAdapterPosition(), false);
//    }
//
//    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
}
