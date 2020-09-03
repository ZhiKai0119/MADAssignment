package com.example.madassignment.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_user);
            email = itemView.findViewById(R.id.email_user);
            tel = itemView.findViewById(R.id.phone_user);
//            cardView = itemView.findViewById(R.id.cardView);
//            cardView.setOnCreateContextMenuListener(this);
        }

//        @Override
//        public void onItemLongClick(View view, int position) {
//            String currentName = getItem(position).getName();
//            String currentEmail = getItem(position).getEmail();
//            String currentTel = getItem(position).getTel();
//            showDeleteDataDialog(currentName, currentEmail, currentTel);
//        }

//        @Override
//        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
//            contextMenu.setHeaderTitle("Delete?");
//            contextMenu.add(getAdapterPosition(), 101, 0, "Yes");
//            contextMenu.add(getAdapterPosition(), 20, 0, "No");
//        }
    }

//    private void showDeleteDataDialog(String currentName, String currentEmail, String currentTel) {
//    }

//    public void RemoveItem(int position){
//        notifyItemRemoved(position);
//        notifyDataSetChanged();
//    }
}
