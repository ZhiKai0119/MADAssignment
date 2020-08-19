package com.example.madassignment.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.madassignment.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private static final String TAG = "RecyclerView";
    private Context mContext;
    private ArrayList<Cart> cartList;

    public RecycleAdapter(Context mContext, ArrayList<Cart> cartList) {
        this.mContext = mContext;
        this.cartList = cartList;
    }



    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shoppingcart_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(cartList.get(position).getPname());
        holder.quantity.setText(cartList.get(position).getQuantity());
        holder.price.setText(cartList.get(position).getQuantity());

        Glide.with(mContext).load(cartList.get(position).getPimage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView price;
        TextView quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }

}
