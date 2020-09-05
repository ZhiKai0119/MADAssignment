package com.example.madassignment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;
import com.example.madassignment.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class purchaseAdapter extends FirebaseRecyclerAdapter<User, purchaseAdapter.viewHolder> {

    public purchaseAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull purchaseAdapter.viewHolder holder, int position, @NonNull User model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.phone.setText(model.getPhoneNo());
        holder.delivery.setText(model.getDelivery());
        holder.address.setText(model.getAddress());
        holder.city.setText(model.getCity());
        holder.state.setText(model.getState());
        holder.postcode.setText(model.getPostcode().toString());
    }

    @NonNull
    @Override
    public purchaseAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_purchase_history_layout, parent, false);
        return new viewHolder(view);
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name, email, phone, address, city, state, postcode, delivery;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.purchase_name);
            email = itemView.findViewById(R.id.purchase_email);
            phone = itemView.findViewById(R.id.purchase_phone);
            address = itemView.findViewById(R.id.purchase_address);
            city = itemView.findViewById(R.id.purchase_city);
            state = itemView.findViewById(R.id.purchase_state);
            postcode = itemView.findViewById(R.id.purchase_postcode);
            delivery = itemView.findViewById(R.id.purchase_delivery);
        }
    }
}
