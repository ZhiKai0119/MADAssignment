package com.example.madassignment.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;

import java.util.ArrayList;

public class AdapterCartItem extends RecyclerView.Adapter<AdapterCartItem.HolderCartItem> {

    private Context context;
    private ArrayList<ModelCartItem> cartItems;

    public AdapterCartItem(Context context, ArrayList<ModelCartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public HolderCartItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cartitem, parent, false);

        return new HolderCartItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCartItem holder, int position) {

        ModelCartItem modelCartItem = cartItems.get(position);

        String id = modelCartItem.getId();
        String pId = modelCartItem.getpId();
        String title = modelCartItem.getName();
        String cost = modelCartItem.getCost();
        String price = modelCartItem.getPrice();
        String quantity = modelCartItem.getQuantity();

        //set data
        holder.itemTitle.setText(""+title);
        holder.itemPrice.setText(""+cost);
        holder.itemQuantity.setText("["+quantity+"]"); //[3]
        holder.itemPriceEach.setText(""+price);

        holder.itemRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return cartItems.size(); //return number of records
    }

    class HolderCartItem extends RecyclerView.ViewHolder {

        private TextView itemTitle, itemPrice, itemPriceEach, itemQuantity, itemRemove;

        public HolderCartItem(@NonNull View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemPrice = itemView.findViewById(R.id.itemPricev);
            itemPriceEach = itemView.findViewById(R.id.itemPriceEach);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemRemove = itemView.findViewById(R.id.itemRemove);
        }
    }
}
