package com.example.madassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madassignment.model.Cart;
import com.example.madassignment.model.RecycleAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;


public class shopping_cart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button mCheckout;
    private TextView mTotalPrice;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private StorageReference mStorage;
    private ArrayList<Cart> cartList;
    private RecycleAdapter recycleAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        recyclerView =findViewById(R.id.shopcart_linear);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleAdapter);

        mRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mStorage = FirebaseStorage.getInstance().getReference();

        cartList = new ArrayList<>();

        GetDataFromFirebase();

        mCheckout = (Button)findViewById(R.id.checkout);
        mCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearAll();
                startActivity(new Intent(shopping_cart.this, ShippingOption.class));
                finish();
            }
        });
        mTotalPrice = (TextView)findViewById(R.id.cartprice);
    }

    private void GetDataFromFirebase() {

        Query query = mRef.child("Shopping Cart").child(mAuth.getCurrentUser().getUid());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Cart cart = new Cart();
                    cart.setPimage(snapshot.child("Image").getValue().toString());
                    cart.setPname(snapshot.child("Name").getValue().toString());
                    cart.setPprice(snapshot.child("Price").getValue().toString());
                    cart.setQuantity(snapshot.child("quantity").getValue().toString());

                    cartList.add(cart);
                }

                recycleAdapter = new RecycleAdapter(mContext, cartList);
                recyclerView.setAdapter(recycleAdapter);
                recycleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void ClearAll() {
        if (cartList != null) {
            cartList.clear();

            if (recycleAdapter != null) {
                recycleAdapter.notifyDataSetChanged();
            }
        }
        cartList = new ArrayList<>();
    }
}