package com.example.madassignment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.madassignment.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class cartAdapter extends FirebaseRecyclerAdapter<Cart, cartAdapter.viewHolder> {

    public cartAdapter(@NonNull FirebaseRecyclerOptions<Cart> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Cart model) {
        holder.name.setText(model.getPname());
        holder.price.setText(model.getPprice());
        holder.quantity.setText(model.getQuantity());
        Glide.with(holder.img.getContext()).load(model.getPimage()).into(holder.img);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shoppingcart_layout, parent, false);
        return new viewHolder(view);
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView price;
        TextView quantity;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}
