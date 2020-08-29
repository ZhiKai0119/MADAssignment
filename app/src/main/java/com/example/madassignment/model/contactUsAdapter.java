package com.example.madassignment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.Member;
import com.example.madassignment.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class contactUsAdapter extends FirebaseRecyclerAdapter<Member, contactUsAdapter.viewHolder> {

    public contactUsAdapter(@NonNull FirebaseRecyclerOptions<Member> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull contactUsAdapter.viewHolder holder, int position, @NonNull Member model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.tel.setText(model.getTel());
    }

    @NonNull
    @Override
    public contactUsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contact_us_layout, parent, false);
        return new viewHolder(view);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, email, tel;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_user);
            email = itemView.findViewById(R.id.email_user);
            tel = itemView.findViewById(R.id.phone_user);
        }
    }
}
