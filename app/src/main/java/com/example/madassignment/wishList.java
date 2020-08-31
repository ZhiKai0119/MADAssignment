package com.example.madassignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.model.WishList;
import com.example.madassignment.model.WishListAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wishList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private WishListAdapter adapter;

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

        FirebaseRecyclerOptions<WishList> options = new FirebaseRecyclerOptions.Builder<WishList>().setQuery(mRef, WishList.class).setLifecycleOwner(this).build();

        adapter = new WishListAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}