package com.example.madassignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.model.Cart;
import com.example.madassignment.model.cartAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class shopping_cart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button mCheckout;
    private TextView mTotalPrice;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private StorageReference mStorage;
    private cartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child(mAuth.getCurrentUser().getUid());
        mRef.keepSynced(true);
        mStorage = FirebaseStorage.getInstance().getReference();

        recyclerView = (RecyclerView) findViewById(R.id.shopcart_linear);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(mRef, Cart.class).setLifecycleOwner(this).build();

        adapter = new cartAdapter(options);
        recyclerView.setAdapter(adapter);

//        mCheckout = (Button)findViewById(R.id.checkout);
//        mCheckout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                ClearAll();
//                startActivity(new Intent(shopping_cart.this, ShippingOption.class));
//                finish();
//            }
//        });
//        mTotalPrice = (TextView)findViewById(R.id.cartprice);
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