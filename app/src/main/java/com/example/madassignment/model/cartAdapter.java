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

public class cartAdapter extends FirebaseRecyclerAdapter<Cart, cartAdapter.viewHolder>{

    private int overTotalPrice = 0;

    public cartAdapter(@NonNull FirebaseRecyclerOptions<Cart> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull Cart model) {
        holder.name.setText("Product Name: " + model.getName());
        holder.price.setText("Product Price: RM" + model.getPrice());
        holder.quantity.setText(model.getQuantity());
//        Picasso.get().load(model.getImage()).into(holder.img);
//        Glide.with(holder.img.getContext()).load(model.getImage()).into(holder.img);
//        Glide.with(holder.img.getContext()).using(new FirebaseImageLoader()).load(model.getImage()).into(holder.img);

        int oneTypeProductPrice = ((Integer.valueOf(model.getPrice()))) * Integer.valueOf(model.getQuantity());
        overTotalPrice = overTotalPrice + oneTypeProductPrice;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shoppingcart_layout, parent, false);
        return new viewHolder(view);
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        TextView quantity;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}
