package com.example.madassignment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.model.WishList;
import com.example.madassignment.model.WishListViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wishList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("Wish List").child(mAuth.getCurrentUser().getUid());
        mRef.keepSynced(true);

        recyclerView = (RecyclerView) findViewById(R.id.wishList_linear);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<WishList> options = new FirebaseRecyclerOptions.Builder<WishList>().setQuery(mRef, WishList.class).setLifecycleOwner(this).build();
        FirebaseRecyclerAdapter<WishList, WishListViewHolder> adapter = new FirebaseRecyclerAdapter<WishList, WishListViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull WishListViewHolder holder, int position, @NonNull final WishList model) {
                holder.wishId.setText("Product ID: " + model.getProduct_id());
                holder.wishName.setText("Product Name: " + model.getProduct_Name());
                holder.wishPrice.setText("Product Price: RM" + model.getProduct_Price());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CharSequence options[] = new CharSequence[]{"Remove"};
                        AlertDialog.Builder builder = new AlertDialog.Builder(wishList.this);
                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(i == 0){
                                    mRef.child(model.getProduct_id()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(wishList.this, "Items removed successfully.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        builder.show();
                    }
                });
            }

            @NonNull
            @Override
            public WishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_layout, parent, false);
                WishListViewHolder holder = new WishListViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}