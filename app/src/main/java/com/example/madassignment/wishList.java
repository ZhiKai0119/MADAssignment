package com.example.madassignment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.model.WishList;
import com.example.madassignment.model.WishListAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        final FirebaseRecyclerOptions<WishList> options = new FirebaseRecyclerOptions.Builder<WishList>().setQuery(mRef, WishList.class).setLifecycleOwner(this).build();

        adapter = new WishListAdapter(options);
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                WishListAdapter.viewHolder wishListViewHolder = (WishListAdapter.viewHolder) viewHolder;
                int a = wishListViewHolder.getAdapterPosition();
//                recyclerView.findViewHolderForAdapterPosition();
//                Toast.makeText(getApplicationContext(), "Testing " + a, Toast.LENGTH_LONG).show();

                mRef.child("Men1").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String value = String.valueOf(snapshot1.child("product_id").getValue());
                            Log.v("OUR VALUE", value);
                            Toast.makeText(getApplicationContext(), "Testing " + value, Toast.LENGTH_LONG).show();
                            mRef.child(String.valueOf(snapshot1)).child(value).removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//                adapter.getSnapshots().remove(direction);
                adapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
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